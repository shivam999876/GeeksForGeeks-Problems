class Solution {
    int[][] dp;

    public int zigzagSequence(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        dp = new int[n][m];

        for (int[] ele : dp) {
            Arrays.fill(ele, -1);
        }

        int ans = 0;
        for (int col = 0; col < m; col++) {
            ans = Math.max(ans, solve(0, col, mat, n, m));
        }

        return ans;
    }

    private int solve(int r, int c, int[][] mat, int n, int m) {


        if (r == n - 1) {
            return mat[r][c];
        }
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int best = 0;
        for (int nextCol = 0; nextCol < m; nextCol++) {

            if (nextCol != c) {
                best = Math.max(
                    best,
                    solve(r + 1, nextCol, mat, n, m)
                );
            }
        }

        dp[r][c] = mat[r][c] + best;

        return dp[r][c];
    }
}