//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String S = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.maxLength(S));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution{
    static int maxLength(String S){
        // code here
        int mx = 0, op = 0, cl = 0, mx2 = 0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='(')op++;
            else cl++;
            if(cl>op){
                op=0;
                cl=0;
            }
            else if(op==cl)mx=Math.max(mx,op*2);
        }
        op=0;
        cl=0;
        for(int i=S.length()-1;i>=0;i--){
            if(S.charAt(i)=='(')op++;
            else cl++;
            if(op>cl){
                op=0;
                cl=0;
            }
            else if(op==cl)mx2=Math.max(mx2,op*2);
        }
        return Math.max(mx,mx2);
    }
}