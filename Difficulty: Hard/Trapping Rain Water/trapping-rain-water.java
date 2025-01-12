//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int pre[] = new int[n];
        int post[] = new int[n];
        pre[0] = arr[0];
        int ans = 0;
        post[n-1] = arr[n-1];
        for(int i = 1; i < n; i++){
            pre[i] = Math.max(pre[i-1],arr[i]);
            
        }
        for(int j = n-2; j >= 0; j--){
            post[j] = Math.max(post[j+1],arr[j]);
        }
        
        for(int i = 0; i < n; i++){
            ans += Math.min(pre[i],post[i]) - arr[i];
        }
        return ans;
    }
}
