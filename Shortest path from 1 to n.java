//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minStep(n));
        }
    }
}
// } Driver Code Ends


class Solution{
    public int minStep(int n)
    {
        // code here
             int c = 0; 
        while(n >= 1){
           c += n%3+1; 
           n /= 3;
        }
        return c-2;
    }
}
