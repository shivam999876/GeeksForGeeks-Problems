//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
          
        int arr3[] = new int[arr1.length + arr2.length];

        // Copy elements from arr1 and arr2 into arr3
        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        
        // Sort the merged array
        Arrays.sort(arr3);
        
        // Get the k-th element (1-based index)
        if (k > 0 && k <= arr3.length) {
            int kthElement = arr3[k - 1];
            return kthElement ;
        } else {
            // System.out.println("Index out of bounds");
            return -1;
        }
    }
}