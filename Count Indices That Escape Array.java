class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;
        int[] memo = new int[n];
        int goodCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (dfs(i, arr, memo) == 2) {
                goodCount++;
            }
        }
        
        return goodCount;
    }
    
    private int dfs(int curr, int[] arr, int[] memo) {
        if (curr < 0 || curr >= arr.length) {
            return 2;
        }
        
        if (memo[curr] != 0) {
            return memo[curr];
        }
        
        if (arr[curr] == 0) {
            return memo[curr] = -1;
        }
        
        memo[curr] = 1;
        
        int nextIndex = curr + arr[curr];
        int result = dfs(nextIndex, arr, memo);
        
        return memo[curr] = result;
    }
}
