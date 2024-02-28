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
            String S=read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.DivisibleByEight(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
 int DivisibleByEight(String s){
        //code here
        int num = 0;
        int i = s.length()-3>=0?s.length()-3:0;
        while(i<s.length()){
            num=num*10+(s.charAt(i)-'0');
            i++;
        }
        return num%8==0?1:-1;
    }
}
