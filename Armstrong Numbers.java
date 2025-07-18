//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution
{
    static String armstrongNumber(int n)
    {
        String s = Integer.toString(n);
        int sum = 0,i = 0;
        while(i<s.length())
        {
            sum+=Math.pow(Character.getNumericValue(s.charAt(i)),3);
            i++;
        }
        if(sum == n)
        return "true";
        else return "false";
    }
}
