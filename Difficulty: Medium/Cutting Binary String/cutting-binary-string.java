class Solution {
    public int cuts(String s) {
        // code here
         char ch[]=s.toCharArray(); int n = s.length();
          int dp[] = new int[n+1];
          dp[0]=0;
          for(int i=1; i<=n; i++)
          {
              int j=i-1;
              if(ch[j]=='0') dp[i]=-1; 
              else{
                  dp[i]=-1;
                  int curr_ans=Integer.MAX_VALUE;
                  int to_dec=0;
                  for(int k=0; k<i; k++)
                  {
                      if(ch[j-k]=='1')
                      {
                          to_dec += 1<<k;
                          if(pow_of_5(to_dec) && dp[j-k]!=-1)
                          {
                               curr_ans = Math.min(1 + dp[j-k] , curr_ans);
                          }
                      }
                  }
                   if(curr_ans!=Integer.MAX_VALUE)
                    dp[i]=curr_ans;
                 } 
          }
          return dp[n];
    }
     static boolean pow_of_5(long n)
    {
        if(n==0)return false;
        if(n==1)return true;
        if(n%5!=0)return false;
        else return pow_of_5(n/5);
    }
}
