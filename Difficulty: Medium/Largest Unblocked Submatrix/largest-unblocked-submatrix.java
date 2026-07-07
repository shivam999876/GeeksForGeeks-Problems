class Solution {
    public int largestArea(int n, int m, int[][] arr) {
        // code here
        java.util.List<Integer> blockedRows = new java.util.ArrayList<>();
        java.util.List<Integer> blockedCols = new java.util.ArrayList<>();
        for (int[] cell : arr) {
            blockedRows.add(cell[0]);
            blockedCols.add(cell[1]);
        }
        blockedRows.add(0);
        blockedRows.add(n + 1);
        blockedCols.add(0);
        blockedCols.add(m + 1);
        java.util.Collections.sort(blockedRows);
        java.util.Collections.sort(blockedCols);
        int maxRowGap = 0;
        for (int i = 1; i < blockedRows.size(); i++) {
            maxRowGap = Math.max(maxRowGap, blockedRows.get(i) - blockedRows.get(i - 1) - 1);
        }
        int maxColGap = 0;
        for (int i = 1; i < blockedCols.size(); i++) {
            maxColGap = Math.max(maxColGap, blockedCols.get(i) - blockedCols.get(i - 1) - 1);
        }
        return maxRowGap * maxColGap;
    }
}