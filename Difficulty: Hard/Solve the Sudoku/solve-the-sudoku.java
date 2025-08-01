//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution {
    // Function to find a solved Sudoku
    static void solveSudoku(int[][] mat) {
        // Use sets to track used numbers in rows, columns, and grids
        boolean[][] rows = new boolean[9][10];  // Rows tracking 1-9
        boolean[][] cols = new boolean[9][10];  // Columns tracking 1-9
        boolean[][] grids = new boolean[9][10]; // Grids tracking 1-9

        // Initialize tracking sets based on the initial board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = mat[i][j];
                if (num != 0) {
                    rows[i][num] = true;
                    cols[j][num] = true;
                    grids[(i / 3) * 3 + (j / 3)][num] = true;
                }
            }
        }

        // Call the solve function with tracking sets
        solve(mat, rows, cols, grids);
    }

    // Function to check if placing 'num' at mat[row][col] is valid
    static boolean isValid(int row, int col, int num, boolean[][] rows, boolean[][] cols, boolean[][] grids) {
        // Check if num is already used in the row, column, or 3x3 grid
        return !rows[row][num] && !cols[col][num] && !grids[(row / 3) * 3 + (col / 3)][num];
    }

    // Recursive function to solve Sudoku using backtracking
    static boolean solve(int[][] mat, boolean[][] rows, boolean[][] cols, boolean[][] grids) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (mat[row][col] == 0) {  // Empty cell found
                    for (int num = 1; num <= 9; num++) {
                        // Check if placing the number is valid
                        if (isValid(row, col, num, rows, cols, grids)) {
                            mat[row][col] = num; // Place the number

                            // Mark the number as used in row, column, and grid
                            rows[row][num] = true;
                            cols[col][num] = true;
                            grids[(row / 3) * 3 + (col / 3)][num] = true;

                            // Recursively try to solve
                            if (solve(mat, rows, cols, grids)) {
                                return true;
                            }

                            // Backtrack
                            mat[row][col] = 0;
                            rows[row][num] = false;
                            cols[col][num] = false;
                            grids[(row / 3) * 3 + (col / 3)][num] = false;
                        }
                    }
                    return false; // If no number fits, return false
                }
            }
        }
        return true;  // Return true if the puzzle is solved
    }
}
