//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String addBinary(String A, String B) {
        // code here
        int carry = 0;
        int i = A.length()-1;
        int j = B.length()-1;
        StringBuilder sb = new StringBuilder("");
        while(carry != 0 || i >= 0 || j >= 0){
            int sum = carry;
            int a = 0;
            int b = 0;
            if(i >= 0){
                a = A.charAt(i--)-'0';
            }
            if(j >= 0){
                b = B.charAt(j--)-'0';
            }
            if(a == 1 && b == 1 && sum == 1){
                sb.append(1);
                carry = 1;
            }else if((a == 1 && b == 1) || (a == 1 && sum == 1) || (b == 1 && sum == 1)){
                sb.append(0);
                carry = 1;
            }else if(a == 1 || b == 1|| sum == 1){
                sb.append(1);
                carry = 0;
            }else{
                sb.append(0);
                carry =0;
            }
        }
        sb.reverse();
        if(sb.length() == 1)return sb+"";
        while(sb.charAt(0) == '0')sb.deleteCharAt(0);
        return sb+"";
    }
}