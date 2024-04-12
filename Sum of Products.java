//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            long Arr[] = new long[N];
            String[] S = read.readLine().split(" ");
            for (int i = 0; i < N; i++) Arr[i] = Long.parseLong(S[i]);
            Solution ob = new Solution();
            System.out.println(ob.pairAndSum(N, Arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static long pairAndSum(int n, long arr[]) {
        // code here
        int bits[] = new int[32];
        Arrays.fill(bits,0);
        for(int i=0;i<n;i++){
            long temp = arr[i];
            int j=0;
            while(temp!=0){
                if((temp&1)==1)bits[j]++;
                temp>>=1;
                j++;
            }
        }
        long ans = 0;
        for(int i=0;i<32;i++){
            long temp = bits[i];
            temp--;
            long pairs = (temp*(temp+1))/2;
            ans+=(pairs*(long)Math.pow(2,i));
        }
        return ans;
    }
}
