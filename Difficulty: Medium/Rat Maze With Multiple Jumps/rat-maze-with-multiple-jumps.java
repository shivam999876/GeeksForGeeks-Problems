class Solution {
    boolean solve(int r, int c, int[][] mat, int[][] path, int[][] dead, int n) {
        if (r < 0 || c < 0 || r >= n || c >= n)
            return false;
        if (r == n - 1 && c == n - 1) {
            path[r][c] = 1;
            return true;
        }
        if (mat[r][c] == 0)
            return false;
        if (dead[r][c] == 1)
            return false;
        path[r][c] = 1;
        int jump = mat[r][c];
        for (int k = 1; k <= jump; k++) {
            if (c + k < n) {
                if (solve(r, c + k, mat, path, dead, n))
                    return true;
            }
            if (r + k < n) {
                if (solve(r + k, c, mat, path, dead, n))
                    return true;
            }
        }
        path[r][c] = 0;
        dead[r][c] = 1;
        return false;
    }
    public ArrayList<ArrayList<Integer>> shortestDist(int[][] mat) {
        int n = mat.length;
        int[][] path = new int[n][n];
        int[][] dead = new int[n][n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (solve(0, 0, mat, path, dead, n)) {
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(path[i][j]);
                }
                ans.add(row);
            }
            return ans;
        }
        ArrayList<Integer> row = new ArrayList<>();
        row.add(-1);
        ans.add(row);
        return ans;
    }
}