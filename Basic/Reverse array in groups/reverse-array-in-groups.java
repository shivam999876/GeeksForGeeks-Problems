//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        
        //while testcases exist
        while(t-->0){
            
            String inputLine1[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine1[0]);
            int k = Integer.parseInt(inputLine1[1]);
            
            ArrayList<Integer> arr = new ArrayList<>();            
            String inputLine2[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr.add(Integer.parseInt(inputLine2[i]));
            }
            
            Solution obj = new Solution();
            obj.reverseInGroups(arr, n, k);
            
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr.get(i) + " ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    //Function to reverse every sub-array group of size k.
   void reverse(ArrayList<Integer>arr,int i,int n,int k){
        // code here
        int l=i;
        int r=Math.min(n-1,i+k-1);
        while(l<r){
            int temp=arr.get(l);
            arr.set(l,arr.get(r));
            arr.set(r,temp);
            l++;r--;
        }
    }
     void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
         for(int i=0; i<n; i+=k){
             reverse(arr,i,n,k);
         }
     }
}
