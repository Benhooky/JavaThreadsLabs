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

        // Read data from the file matrix.txt
        File file = new File("Java/2_lab/matrix.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(fileInputStream);
        n = scanner.nextInt();

        // Create the matrix
        A = new double[n][n];

        // Read the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scanner.nextDouble();
            }
        }

        // Create vector b
        b = new double[n];

        // Read vector b
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextDouble();
        }

        // Close the scanner and stream
        scanner.close();
        x = new double[n];
        SLAUSolver solver = new SLAUSolver(n);
        solver.solve(A, b, x);

        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
