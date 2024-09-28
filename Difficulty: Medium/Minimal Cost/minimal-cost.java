//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
     int help(int i,int k,int arr[],int dp[]){
        if(i==arr.length-1)return 0;
        if(dp[i]!=-1)return dp[i];
        int ans = Integer.MAX_VALUE;
        for(int j=i+1;j<=i+k && j<arr.length;j++){
            int cost = Math.abs(arr[i]-arr[j])+help(j,k,arr,dp);
            ans=Math.min(ans,cost);
        }
        return dp[i] = ans;
    }
    public int minimizeCost(int k, int arr[]) {
        // code here
        int dp[] = new int[arr.length];
        Arrays.fill(dp,-1);
        return help(0,k,arr,dp);
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(k, arr);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends