//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            
            String input_line[] = br.readLine().trim().split("\\s+");
            int[][] matrix = new int[n][n];
            for(int i=0; i<n; i++) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = Integer.parseInt(input_line[i * n + j]); 
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.antiDiagonalPattern(matrix);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] antiDiagonalPattern(int[][] matrix)
    {
        // Code here
         int n = matrix.length;
        int ans[] = new int[n*n];
        ans[0] = matrix[0][0];
        int ind = 1;
        
        for(int j=1; j<n; j++){
            int x = 0; int y = j;
            while(x <= j && y >= 0){
                ans[ind] = matrix[x][y];
                ind++; y--; x++;
            }
        }
        
        for(int i=1; i<n; i++){
            int x = i; int y = n-1;
            while(x < n){
                ans[ind] = matrix[x][y];
                ind++; x++; y--;
            }
        }
        return ans;
    }
}
