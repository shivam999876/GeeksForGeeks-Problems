//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palPartition(str));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int palPartition(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        
        boolean[][] isPalin = new boolean[n][n];
        int[] dp = new int[n];

        // Step 1: Precompute palindrome substrings
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    isPalin[i][j] = true;  // Single character
                } else if (gap == 1) {
                    isPalin[i][j] = (s.charAt(i) == s.charAt(j));  // Two characters
                } else {
                    isPalin[i][j] = (s.charAt(i) == s.charAt(j) && isPalin[i + 1][j - 1]);
                }
            }
        }

        // Step 2: Fill DP table
        for (int i = 0; i < n; i++) {
            if (isPalin[0][i]) {
                dp[i] = 0;  // No cuts needed
            } else {
                int minCuts = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (isPalin[j + 1][i]) {
                        minCuts = Math.min(minCuts, 1 + dp[j]);
                    }
                }
                dp[i] = minCuts;
            }
        }

        return dp[n - 1];  // Minimum cuts needed
    }
}
