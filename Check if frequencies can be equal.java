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
            
            String input[] = read.readLine().split(" ");
            String a = input[0];
            
            Solution ob = new Solution();
            if(ob.sameFreq(a)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
// } Driver Code Ends

//User function Template for Java
class Solution {
    boolean sameFreq(String s) {
        // code here
        HashMap<Character,Integer> mm = new HashMap<>();
	    for(int i=0;i<s.length();i++){
	        mm.put(s.charAt(i),mm.getOrDefault(s.charAt(i),0)+1);
	    }
	    int mn=Integer.MAX_VALUE,mx=Integer.MIN_VALUE,mxCount=0,mnCount=0;
	    for(Map.Entry<Character,Integer> x : mm.entrySet()){
	        mn=Math.min(mn,x.getValue());
	        mx=Math.max(mx,x.getValue());
	    }
	    for(Map.Entry<Character,Integer> x : mm.entrySet()){
	        if(x.getValue()==mx)mxCount++;
	        else if(x.getValue()==mn)mnCount++;
	    }
	    if(mn==mx-1 && mxCount==1 || (mn==mx))return true;
	    if(mnCount==1 && mn==1 && mxCount+mnCount==mm.size())return true;
	    return false;
    }
}
