//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.searchRowMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        // code here
        int n=mat.length,m=mat[0].length;
        for(int i=0;i<n;i++){
            if (x < mat[i][0] || x > mat[i][m - 1])continue;
            int low=0,high=m-1,mid;
            while(low<=high){
                mid=(low+high)/2;
                int temp = mat[i][mid];
                if(temp==x)return true;
                else if(temp<x)low=mid+1;
                else high=mid-1;
            }
        }
        return false;
    }
}
