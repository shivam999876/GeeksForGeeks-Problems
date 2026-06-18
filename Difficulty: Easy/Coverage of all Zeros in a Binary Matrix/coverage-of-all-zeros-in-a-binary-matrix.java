class Solution {
    public int findCoverage(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int totalCoverage = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    int coverage = 0;
                    for (int l = j - 1; l >= 0; l--) {
                        if (mat[i][l] == 1) {
                            coverage++;
                            break;
                        }
                    }
                    for (int r = j + 1; r < cols; r++) {
                        if (mat[i][r] == 1) {
                            coverage++;
                            break;
                        }
                    }
                    for (int u = i - 1; u >= 0; u--) {
                        if (mat[u][j] == 1) {
                            coverage++;
                            break;
                        }
                    }
                    for (int d = i + 1; d < rows; d++) {
                        if (mat[d][j] == 1) {
                            coverage++;
                            break;
                        }
                    }
                    totalCoverage += coverage;
                }
            }
        }
        return totalCoverage;
    }
}