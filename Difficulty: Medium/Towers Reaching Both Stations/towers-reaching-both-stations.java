class Solution {

    private static final int[][] DIRS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    int n, m;

    public int countCoordinates(int[][] mat) {
        
        n = mat.length;
        m = mat[0].length;
        
        boolean[][] station1 = new boolean[n][m];
        boolean[][] station2 = new boolean[n][m];
        for (int j = 0; j < m; j++) {
            dfs(0, j, mat, station1);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, 0, mat, station1);
        }
        for (int j = 0; j < m; j++) {
            dfs(n - 1, j, mat, station2);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, m - 1, mat, station2);
        }
        
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (station1[i][j] && station2[i][j]) {
                    ans++;
                }
            }
        }
        
        return ans;
    }

    private void dfs(int i, int j, int[][] mat, boolean[][] vis) {
        if (vis[i][j]) return;
        
        vis[i][j] = true;
        
        for (int[] d : DIRS) {
            
            int ni = i + d[0];
            int nj = j + d[1];
            
            if (ni < 0 || ni >= n || nj < 0 || nj >= m)
                continue;
            if (mat[ni][nj] >= mat[i][j]) {
                dfs(ni, nj, mat, vis);
            }
        }
    }
}