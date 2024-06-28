//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String pattern(int[][] arr) {
        // Code here
        String str = "";
        int n = arr.length;

         //Checking for rows---because of first priority
        for(int i=0;i<n;i++){
            int[] palin = new int[n];
            for(int j=0;j<n;j++){
                palin[j] = arr[i][j];
            }
            if(palindrome(palin)){
                str = i+" R";
                return str;
            }
        }
        //Checking for columns---because of second priority...
        for(int i=0;i<n;i++){
            int[] palin = new int[n];
            for(int j=0;j<n;j++){
                palin[j] = arr[j][i];
            }
            if(palindrome(palin)){
                str = i+" C";
                return str;
            }
        }
        return "-1";
    }

//Function to check weather the given row or column is palindrome or not
    private boolean palindrome(int[] palin){
        if(palin.length==0){
            return false;
        }
        int n = palin.length;
        
        int count = 0;
        for(int i=0;i<n;i++){
            if(palin[i]!=palin[n-1-i]){
                return false;
            }
        }
        return true;
        
    }
    
}
