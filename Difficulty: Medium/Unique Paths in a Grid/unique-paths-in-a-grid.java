class Solution {
    public int uniquePaths(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] dp = new int[m];
        
        dp[0] = (grid[0][0] == 1) ? 0 : 1; 
        
        for (int i = 1; i < m; i++) {
            dp[i] = (grid[0][i] == 1) ? 0 : dp[i - 1];
        }
        
        for (int i = 1; i < n; i++) {
            if (grid[i][0] == 1) dp[0] = 0;    // Deals with first column
            for (int j = 1; j < m; j++) {
                dp[j] = (grid[i][j] == 1) ? 0 : dp[j] + dp[j - 1];
            }
        }
        
        return dp[m - 1];
    }
};