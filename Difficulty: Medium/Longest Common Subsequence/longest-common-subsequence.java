//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            String s1 = sc.next(); // Take both the strings as input
            String s2 = sc.next();

            Solution obj = new Solution();

            // Call the lcs function with the lengths of the strings as
            // parameters
            System.out.println(obj.lcs(s1, s2));
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends






class Solution {
     static int lcsRec(String s1, String s2, int m, int n,
                   int[][] memo) {
        if (m == 0 || n == 0)
            return 0;
        if (memo[m][n] != -1)
            return memo[m][n];
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n]
                = 1 + lcsRec(s1, s2, m - 1, n - 1, memo);
        }
        return memo[m][n]
            = Math.max(lcsRec(s1, s2, m, n - 1, memo),
                       lcsRec(s1, s2, m - 1, n, memo));
    }
    static int lcs(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return lcsRec(s1, s2, m, n, memo);
    }
}