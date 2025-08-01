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
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{

    static boolean isPalindrome(int i, int j, String s) {

        while (i < j) {

            if (s.charAt(i) != s.charAt(j))

                return false;

            i++; j--;

        }

        return true;

    }

    

    static int solve(int idx, int n, String s, int[] dp) {

        if (idx == n)

            return 0;

        

        if (dp[idx] != -1)

            return dp[idx];

        

        int mini = Integer.MAX_VALUE;

        for (int i=idx; i<n; i++) {

            if (isPalindrome(idx, i, s)) {

                mini = Math.min(mini, 1 + solve(i + 1, n, s, dp));

            }

            

        }

        

        return dp[idx] = mini;

    }

    

    

    static int palindromicPartition(String str){

        int n = str.length();

        int[] dp = new int[n];

        for (int i=0; i<n; i++) {

            dp[i] = -1;

        }

        return solve(0, n, str, dp) - 1;

    }

}