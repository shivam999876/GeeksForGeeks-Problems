//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static String longestSubstring(String s, int N) {
        int[][] LCS = new int[N + 1][N + 1];

        int res_length = 0; 
        int idx = 0; 


        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1) &&
                    LCS[i - 1][j - 1] +1 <= (j - i)) {  //no overlapping
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;

                    if (LCS[i][j] > res_length) { // do not update for equal, need 1st occurence
                        res_length = LCS[i][j];
                        idx = i-1;
                    }
                } 
            }
        }

        StringBuilder res = new StringBuilder(); // To store result
        if (res_length > 0) {
            for (int i = idx - res_length + 1; i <= idx; i++) {
                res.append(s.charAt(i));
            }
        } 
        else 
            res.append("-1");

        return res.toString();
    }
}
