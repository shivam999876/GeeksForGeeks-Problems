class Solution
{   static  int MOD = 1000000007;
    public static int ways(int x, int y)
    {
        // complete the function
        int memo[][] = new int[x+1][y+1];
        for(int row[] : memo)
        Arrays.fill(row,-1);

        return dfs(x,y,memo);
    }
    static int dfs(int x, int y, int memo[][]){
        if(x==0 && y==0) return 1;

        if(memo[x][y]!=-1) return memo[x][y];

        int cnt=0;
        if(x>0)
        cnt = (cnt + dfs(x-1,y,memo))%MOD;

        if(y>0)
        cnt = (cnt + dfs(x,y-1,memo))%MOD;

        return memo[x][y] = cnt;
    }
}
