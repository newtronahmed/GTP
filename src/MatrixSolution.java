import java.util.Scanner;

public class MatrixSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Matrix A
            System.out.print("Matrix A: ");

            String dimensionA = scanner.nextLine();
            String[] dimensionAArray = dimensionA.split(",");
            int n = Integer.parseInt(dimensionAArray[0].trim());
            int m = Integer.parseInt(dimensionAArray[1].trim());

            // Input matrix A
            double[][] A = inputMatrix(scanner, n, m);

            // Matrix B
            System.out.print("Matrix B: ");
            String dimensionB = scanner.nextLine();
            String[] dimensionBArray = dimensionB.split(",");
            int m2 = Integer.parseInt(dimensionBArray[0].trim());
            int p = Integer.parseInt(dimensionBArray[1].trim());

            // Check if the inner dimensions match for multiplication
            if (m != m2) {
                System.out.println("Error: The number of columns in Matrix A must be equal to the number of rows in Matrix B.");
                return;
            }

            // Input matrix B
            double[][] B = inputMatrix(scanner, m, p);

            // Multiply matrices A and B and store in C
            double[][] C = multiplyMatrices(A, B);

            // Display the resulting matrix C
            System.out.println("\nMatrix C:");
            displayMatrix(C);

        } catch (Exception e) {
            System.out.println("Invalid input. Please make sure the dimension follows this format m,n where m and n are digits");

        } finally {
            scanner.close();
        }
    }

    // Take input of a matrix from the user
    public static double[][] inputMatrix(Scanner scanner, int rows, int cols) {

        double[][] matrix = new double[rows][cols];
        System.out.println("Enter the elements of the " + rows + "x" + cols + " matrix row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        //consume next line
        scanner.nextLine();
        return matrix;
    }

    // Multiply two matrices A and B
    public static double[][] multiplyMatrices(double[][] A, double[][] B) {
        int n = A.length;
        int m = A[0].length;
        int p = B[0].length;

        double[][] C = new double[n][p];

        // Perform matrix multiplication
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < m; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    //  Display the matrix
    public static void displayMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            System.out.print("|");
            for (double val : row) {
                System.out.printf(" %d ", (int) val);
            }
            System.out.println("|");
        }
    }
}
