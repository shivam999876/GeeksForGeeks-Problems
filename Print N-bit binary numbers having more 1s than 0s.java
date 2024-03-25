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
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int n) {
        // code here
        int cnt1=0; int cnt0=0;
        ArrayList<String> al = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        
        fun(n, cnt1, cnt0, curr, al);
        return al;
    }
    void fun(int n, int cnt1, int cnt0, StringBuilder curr, List<String> al)
    {
        if(n==0){
            al.add(curr.toString());
            return;
        }
        fun(n - 1, cnt1 + 1, cnt0, new StringBuilder(curr).append("1"), al);
        if(cnt1 > cnt0){
            //Create a new StringBuilder instance for each recursive call
            fun(n - 1, cnt1, cnt0 + 1, new StringBuilder(curr).append("0"), al);
        }
    }
}
