//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    int maxProduct(int[] arr) {
        // code here
        int ans =Integer.MIN_VALUE,productStart = 1, productEnd = 1, n = arr.length;
        for(int i = 0; i< n ;i++){
            productStart *= arr[i];
            productEnd *= arr[n - 1 - i];
            ans = Math.max(ans, Math.max(productStart, productEnd));
            if(productStart == 0) productStart = 1;
            if(productEnd == 0) productEnd = 1;
        }
        return ans;
    }
}