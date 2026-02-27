class Solution {
    public int countSquare(int[][] mat, int x) {
        int rows = mat.length;
        if (rows == 0) return 0;
        int cols = mat[0].length;
        
        int[][] gridSum = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                gridSum[i][j] = mat[i - 1][j - 1] 
                                + gridSum[i - 1][j] 
                                + gridSum[i][j - 1] 
                                - gridSum[i - 1][j - 1];
            }
        }

        int sqSubMatrices = 0;
        int maxPossibleSide = Math.min(rows, cols);

        for (int side = 1; side <= maxPossibleSide; side++) {
            for (int i = side; i <= rows; i++) {
                for (int j = side; j <= cols; j++) {
                    
                    int currentSum = gridSum[i][j] 
                                   - gridSum[i - side][j] 
                                   - gridSum[i][j - side] 
                                   + gridSum[i - side][j - side];

                    if (currentSum == x) {
                        sqSubMatrices++;
                    }
                }
            }
        }

        return sqSubMatrices;
    }
}