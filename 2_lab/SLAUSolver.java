class SLAUSolver {
    private final int n; // Dimension of the system of linear equations (СЛАУ)

    public SLAUSolver(int n) {
        this.n = n;
    }

    // Forward pass
    private void forwardPass(double[][] A, double[] b, double[] alpha, double[] beta) {
        // Calculate initial values
        alpha[0] = -A[0][1] / A[0][0];
        beta[0] = b[0] / A[0][0];

        // Iterate through equations starting from the second one
        for (int i = 1; i < n - 1; i++) {
            double denom = A[i][i] + A[i][i - 1] * alpha[i - 1];
            alpha[i] = -A[i][i + 1] / denom;
            beta[i] = (b[i] - A[i][i - 1] * beta[i - 1]) / denom;
        }

        // Calculate the last element separately
        int lastIdx = n - 1;
        beta[lastIdx] = (b[lastIdx] - A[lastIdx][lastIdx - 1] * beta[lastIdx - 1])
                / (A[lastIdx][lastIdx] + A[lastIdx][lastIdx - 1] * alpha[lastIdx - 1]);
    }

    // Backward pass
    private void backwardPass(double[][] A, double[] b, double[] alpha, double[] beta, double[] x) {
        // Find the last solution element
        x[n - 1] = beta[n - 1];

        // Backward pass
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
