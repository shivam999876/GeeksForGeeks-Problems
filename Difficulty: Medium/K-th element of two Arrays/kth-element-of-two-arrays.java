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
            int[] a = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                a[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] b = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                b[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(a, b, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends






// User function Template for Java
class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int count=0;
        int i=0,j=0;
        while(i<a.length&&j<b.length){
            if(a[i]<=b[j]){
                count++;
                if(count==k){
                    return a[i];
                }
                i++;
            }else{
                count++;
                if(count==k){
                    return b[j];
                }
                j++;
            }
        }
        while(i<a.length){
            count++;
                if(count==k){
                    return a[i];
                }
                i++;
        }
        while(j<b.length){
            count++;
                if(count==k){
                    return b[j];
                }
                j++;
        }
        return -1;
        
    }
}

