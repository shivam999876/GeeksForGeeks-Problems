//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][][] dp;

    static int countWays(int n, String s){
        dp = new int[n][n][2];
        for (int[][] d1 : dp) {
            for (int[] d2 : d1) {
                Arrays.fill(d2, -1);
            }
        }
         return solve(s, 0, n - 1, 1) % 1003;
    }
     static int solve(String str, int i, int j, int isTrue) {
        if (i > j) return 0;
        if (i == j) return (str.charAt(i) == (isTrue == 1 ? 'T' : 'F')) ? 1 : 0;
         if (dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        int temp_ans = 0;

        for (int k = i + 1; k <= j - 1; k += 2) {
            int lt = solve(str, i, k - 1, 1);
            int lf = solve(str, i, k - 1, 0);
            int rt = solve(str, k + 1, j, 1);
            int rf = solve(str, k + 1, j, 0);

            if (str.charAt(k) == '&') {
                temp_ans += (isTrue == 1) ? (lt * rt) : (lt * rf + lf * rt + lf * rf);
            } else if (str.charAt(k) == '|') {
                temp_ans += (isTrue == 1) ? (lt * rt + lt * rf + lf * rt) : (lf * rf);
            } else if (str.charAt(k) == '^') {
                temp_ans += (isTrue == 1) ? (lt * rf + lf * rt) : (lt * rt + lf * rf);
            }
        }
        return dp[i][j][isTrue] = temp_ans % 1003;
    }
}
