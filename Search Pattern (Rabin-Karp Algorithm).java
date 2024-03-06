//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            Solution ob = new Solution();
            ArrayList<Integer> res = ob.search(patt, s);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends
//User function Template for Java
class Solution
{
    int d = 256;
    int mod = 101; //handle OverFlow - Choose preferably prime
    ArrayList<Integer> search(String pattern, String text)
    {
        // your code here
        int n = text.length();
        int m = pattern.length();
        ArrayList<Integer> al = new ArrayList<Integer>();
        //Computing d^m-1; m is pattern length; //Calculating weighted hash => m 
        long h = 1;
        for(int i = 1; i <= m-1; i++)
        h = (h*d)%mod;
        //Computing hash for pattern in p and text in t
        long p = 0, t = 0;
        for(int i = 0; i < m; i++){
            p = (p * d + pattern.charAt(i)) % mod;
            t = (t * d + text.charAt(i)) % mod;
        }
        for(int i = 0; i <= n-m; i++){
            if(p == t){//Handling superious hit
            boolean flag = true;
            for(int j = 0; j < m; j++){
                if(text.charAt(i + j) != pattern.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag)
            al.add(i + 1);
            }
            //Rolling Hash - compute next hash using prevous hash
            if(i < n-m){
                t = (d*(t - text.charAt(i)*h) + text.charAt(i + m)) % mod;
                if(t < 0) t = t + mod;
            }
        }
        return al;
    }
}
