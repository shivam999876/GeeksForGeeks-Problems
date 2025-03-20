//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {

public int solveMem(int [] arr, int idx, int [] dp){
        if(idx >= arr.length){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int include = solveMem(arr,idx + 1,dp);
        int exclude = arr[idx] + solveMem(arr,idx + 2,dp);
        return dp[idx] = Math.max(include,exclude);
    }

public int findMaxSum(int arr[]) {
        int n = arr.length;
        int [] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        return solveMem(arr,0,dp);
    }
}