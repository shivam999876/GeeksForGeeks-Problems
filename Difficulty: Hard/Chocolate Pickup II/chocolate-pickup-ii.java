class Solution {
    int n;
    int[][] grid;
    int[][][] dp;

    public int chocolatePickup(int[][] mat) {
        //Code here
        n = mat.length;
        grid = mat;
        dp = new int [n][n][n];
        
        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, -2);

        int ans = helper(0, 0, 0);
        return Math.max(ans, 0);
    }

    private int helper(int r1, int c1, int r2) {
        int c2 = r1 + c1 - r2;

        
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n) 
            return Integer.MIN_VALUE;

        
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) 
            return Integer.MIN_VALUE;

        
        if (r1 == n-1 && c1 == n-1) 
            return grid[r1][c1];

        if (dp[r1][c1][r2] != -2) 
            return dp[r1][c1][r2];

        
        int val = grid[r1][c1];
        if (r1 != r2 || c1 != c2)   
            val += grid[r2][c2];

        
        int best = Integer.MIN_VALUE;

        best = Math.max(best, helper(r1+1, c1, r2+1));   
        best = Math.max(best, helper(r1+1, c1, r2));     
        best = Math.max(best, helper(r1, c1+1, r2+1));   
        best = Math.max(best, helper(r1, c1+1, r2));     

        
        if (best == Integer.MIN_VALUE)
            return dp[r1][c1][r2] = Integer.MIN_VALUE;

        
        return dp[r1][c1][r2] = val + best;
    }
}