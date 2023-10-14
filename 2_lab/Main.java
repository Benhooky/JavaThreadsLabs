import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        double[][] A;
        double[] b;
        double[] x;
        int n;
        // Считываем данные из файла matrix.txt
        File file = new File("Java/2_lab/matrix.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fileInputStream);
        n = scanner.nextInt();

        // Создание матрицы
        A = new double[n][n];

        // Чтение матрицы
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scanner.nextDouble();
            }
        }

        // Создание вектора b
        b = new double[n];

        // Чтение вектора b
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextDouble();
        }

        // Закрытие сканнера и потока
        scanner.close();
        x = new double[n];
        SLAUSolver solver = new SLAUSolver(n);
        solver.solve(A, b, x);

        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}