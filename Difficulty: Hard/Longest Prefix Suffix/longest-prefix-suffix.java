//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String s) {
        // code here
        int length = s.length();
        int lps[] = new int[length]; // making an array equal to pattern length 
        lps[0]=0; // always zero 
        int i =1;
        int len = 0;
        while(i<length){
        if(s.charAt(i)==s.charAt(len)){
        len++;
        lps[i]=len;
        i++;

        }else{
            if(len!=0){
                len = lps[len-1];
            } else{
           lps[i]=0;
           i++;

            }
        }
        }
        return  lps[length-1];
    }
}

