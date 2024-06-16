import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class PeakColumnSolution {
    public static void main (String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Matrix A:");
            String dimension = scanner.nextLine();
            String[] dimensions = dimension.split(",");

            if (dimensions.length != 2) {
                throw new IllegalArgumentException("Please provide dimensions in the format 'rows,columns'");
            }

            int row = Integer.parseInt(dimensions[0].trim());
            int column = Integer.parseInt(dimensions[1].trim());

            if (row <= 0 || column <= 0) {
                throw new IllegalArgumentException("Rows and columns must be positive integers");
            }

            double[][] matrix = inputMatrix(scanner, row, column);
            getPeakColumnsOptimized(matrix);

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter valid integers for rows and columns.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
        } catch (NoSuchElementException e) {
            System.out.println("Error: No input provided.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
    public static double[][] inputMatrix(Scanner scanner, int row,int column){
        double [][] A = new double[row][column];
        System.out.println("Enter the elements of the " + row + "x" + column + " matrix row by row:");
        for(int i = 0; i < row; i++){
            for(int j =0; j < column; j++){
                A[i][j] = scanner.nextDouble();
            }
        }
        return A;
    }

    private static void getPeakColumnsOptimized(double[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int n = matrix.length;    // n is the number of rows
        int m = matrix[0].length; // m is the number of columns

        // Precompute column minimums
        double[] colMinimums = new double[m];
        for (int j = 0; j < m; j++) {
            colMinimums[j] = matrix[0][j];
            for (int i = 1; i < n; i++) {
                colMinimums[j] = Math.min(colMinimums[j], matrix[i][j]);
            }
        }

        // Find peak columns
        for (int i = 0; i < n; i++) {
            // Find row maximum
            double rowMax = matrix[i][0];
            for (int j = 1; j < m; j++) {
                rowMax = Math.max(rowMax, matrix[i][j]);
            }

            // Check if row maximum is also a column minimum
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == rowMax && matrix[i][j] == colMinimums[j]) {
                    System.out.println("A (" + (i + 1) + ", " + (j + 1) + ") = " + (int)rowMax);

                }
            }
        }
    }
}