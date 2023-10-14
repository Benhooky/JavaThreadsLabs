class SLAUSolver {
    private final int n; // Размерность СЛАУ

    public SLAUSolver(int n) {
        this.n = n;
    }

    // Левая прогонка
    private void forwardPass(double[][] A, double[] b, double[] alpha, double[] beta) {
        // Вычисляем начальные значения
        alpha[0] = -A[0][1] / A[0][0];
        beta[0] = b[0] / A[0][0];

        // Проходим по уравнениям, начиная со второго
        for (int i = 1; i < n - 1; i++) {
            double denom = A[i][i] + A[i][i - 1] * alpha[i - 1];
            alpha[i] = -A[i][i + 1] / denom;
            beta[i] = (b[i] - A[i][i - 1] * beta[i - 1]) / denom;
        }

        // Отдельно вычисляем последний элемент
        int lastIdx = n - 1;
        beta[lastIdx] = (b[lastIdx] - A[lastIdx][lastIdx - 1] * beta[lastIdx - 1])
                / (A[lastIdx][lastIdx] + A[lastIdx][lastIdx - 1] * alpha[lastIdx - 1]);
    }

    // Правая прогонка
    private void backwardPass(double[][] A, double[] b, double[] alpha, double[] beta, double[] x) {
        // Находим последний элемент решения
        x[n - 1] = beta[n - 1];

        // Обратный проход
        for (int i = n - 2; i >= 0; i--) {
            x[i] = alpha[i] * x[i + 1] + beta[i];
        }
    }

    public void solve(double[][] A, double[] b, double[] x) {
        double[] alpha = new double[n];
        double[] beta = new double[n];

        Thread forwardThread = new Thread(() -> forwardPass(A, b, alpha, beta));
        Thread backwardThread = new Thread(() -> backwardPass(A, b, alpha, beta, x));

        forwardThread.start();
        backwardThread.start();

        try {
            forwardThread.join();
            backwardThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}