//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        int[] lastIndex = new int[256]; // To store the last index of each character
        
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }
        
        for (int end = 0; end < n; end++) {
            start = Math.max(start, lastIndex[s.charAt(end)] + 1);
            maxLength = Math.max(maxLength, end - start + 1);
            lastIndex[s.charAt(end)] = end;
        }
        
        return maxLength;
    }
}