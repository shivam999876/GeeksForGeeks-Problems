//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    matrix[i][j] = sc.nextInt();

            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.sumTriangles(matrix,n);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends




//User function Template for Java


class Solution {
    // Function to return sum of upper and lower triangles of a matrix.
    static ArrayList<Integer> sumTriangles(int mat[][], int n) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int s1 = 0, s2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                s1 += mat[i][j];
            }
            for (int j = 0; j <= i; j++) {
                s2 += mat[i][j];
            }
        }
        al.add(s1);
        al.add(s2);
        return al;
    }
}
