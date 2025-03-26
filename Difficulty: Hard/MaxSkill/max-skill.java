//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxSkill(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int maxSkill(int[] arr) {
        int n = arr.length;
        int[] nums = new int[n + 2]; // Add boundary 1s
        nums[0] = 1;
        nums[n + 1] = 1;
        System.arraycopy(arr, 0, nums, 1, n);

        int[][] dp = new int[n + 2][n + 2]; // DP table

        // Fill DP table for increasing subarray lengths
        for (int len = 1; len <= n; len++) {
            for (int l = 1; l <= n - len + 1; l++) {
                int r = l + len - 1;
                // Try removing each person in range [l, r]
                for (int i = l; i <= r; i++) {
                    int skill = nums[l - 1] * nums[i] * nums[r + 1];
                    skill += dp[l][i - 1] + dp[i + 1][r];
                    dp[l][r] = Math.max(dp[l][r], skill);
                }
            }
        }

        return dp[1][n]; // Maximum skill for the entire array
    }
}

