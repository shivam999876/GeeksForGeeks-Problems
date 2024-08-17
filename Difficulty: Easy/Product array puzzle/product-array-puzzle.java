//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        // code here
        long temp = 1, c = 0;
        int n = nums.length, index = -1;
        for(int i=0;i<n;i++){
            if(nums[i] != 0) temp *= nums[i];
            else{
                c++;
                index=i;
            }
        }
        long ans[] = new long[n];
        if(c>1)return ans;
        if(c==1){
            ans[index]=temp;
            return ans;
        }
        for(int i=0; i<n; i++){
            ans[i] = temp/nums[i];
        }
        return ans;
    }
}
