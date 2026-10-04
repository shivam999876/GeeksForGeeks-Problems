class Solution {
    private static int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static int findPerimeter(int[][] mat) {
        int perimeter = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    perimeter += dfs(mat, i, j);
                }
            }
        }

        return perimeter;
    }

    private static int dfs(int[][] mat, int row, int col) {
        mat[row][col] = -1;

        int perimeter = 0;
        for (int[] dir: directions) {
            int x = row + dir[0];
            int y = col + dir[1];

            if (x < 0 || x == mat.length || y < 0 || y == mat[0].length || mat[x][y] == 0) {
                perimeter++;
                continue;
            }

            if (mat[x][y] == 1) {
                perimeter += dfs(mat, x, y);
            }
        }

        return perimeter;
    }
}
