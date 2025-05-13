//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int r = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends






// User function Template for Java

class Solution{
    static int nCr(int n, int r)
    {
        // code here
        if(r>n)return 0;
        if(r==n || r==0)return 1;
        int dp[]=new int[r+1];
        dp[0]=1;
        int mod=1000000007;
        for(int i=1;i<=n;i++){
            for(int j=Math.min(i,r);j>0;j--){
                dp[j]=(dp[j]+dp[j-1])%mod;
            }
        }
        return dp[r];
    }
}