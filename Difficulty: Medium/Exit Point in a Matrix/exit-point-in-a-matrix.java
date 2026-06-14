class Solution {
    public List<Integer> exitPoint(int[][] mat) {
        
        int n = mat.length, m = mat[0].length;
        
        int[][] delta = {{0, +1}, {+1, 0}, {0, -1}, {-1, 0}};
        int row = 0, col = 0;
        int d = 0;
        
        while (true) {
            if (mat[row][col] == 1) {
                mat[row][col] = 0;
                d = (d +1) % 4;
            }
            
            int nr = row + delta[d][0];
            int nc = col + delta[d][1];
            
            if ((nr < 0 || nr >= n) || (nc < 0 || nc >= m))
                return new ArrayList<>(List.of(row, col));
                
            row = nr;
            col = nc;
        }
    }
}