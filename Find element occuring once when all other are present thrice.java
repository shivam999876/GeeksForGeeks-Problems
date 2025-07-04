//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.singleElement(arr,N));
        }
    }
}
// } Driver Code Ends

//User function Template for Java

class Solution {
    static int singleElement(int[] nums , int N) {
        // code here
        int res = 0;
        for(int i = 0; i < 32; i++){
            int ans = 0;
            for(int j = 0; j<nums.length; j++){
                if((nums[j] & (1<<i)) != 0)
                ans++;
            }
            if(ans%3==1)
            res+=(1<<i);
        }
        return res;
    }
}
