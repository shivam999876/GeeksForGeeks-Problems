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
            System.out.println(ob.largestSwap(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String largestSwap(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int maxIdx = n - 1;
        int swapIdx1 = -1, swapIdx2 = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[maxIdx]) {
                swapIdx1 = i;
                swapIdx2 = maxIdx;
            } else if (arr[i] > arr[maxIdx]) {
                maxIdx = i;
            }
        }

        if (swapIdx1 != -1) {
            char temp = arr[swapIdx1];
            arr[swapIdx1] = arr[swapIdx2];
            arr[swapIdx2] = temp;
        }
        
        return new String(arr);
    }
}