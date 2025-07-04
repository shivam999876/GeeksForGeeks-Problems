//{ Driver Code Starts
import java.util.*;

class Distinct_Occurrences
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String S = line.split(" ")[0];
			String T = line.split(" ")[1];
			
			Solution ob = new Solution();
			System.out.println(ob.subsequenceCount(S,T));
			t--;
		}
	}
}
// } Driver Code Ends

/*You are required to complete this method*/

class Solution
{
    static int mod = 1000000007;
	    static int help(String s, String t, int i, int j, int dp[][]){
	    if(j==t.length()) return 1;
	    if(i==s.length()) return 0;
	    if(dp[i][j]!=-1) return dp[i][j];
	    int a = 0, b = 0;
	    if(s.charAt(i) == t.charAt(j)){
	    a = help(s,t,i+1,j+1,dp);
	    }
	    b = help(s,t,i+1,j,dp);
	    return dp[i][j] = (a+b)%mod;
	}
    int  subsequenceCount(String s, String t)
    {
	// Your code here
	int n = s.length();
	int m = t.length();
	int dp[][] = new int[n][m];
	for(int temp[]:dp)Arrays.fill(temp,-1);
	return help(s,t,0,0,dp);
    }
}
