class Solution {
    public int LCIS(int[] a, int[] b) {
        // code here
       int n = a.length;
        int m = b.length;

        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            int current = 0;
            for (int j = 0; j < n; j++) {
                if (b[i] == a[j]) {
                    dp[j] = Math.max(dp[j], current + 1);
                } else if (b[i] > a[j]) {
                    current = Math.max(current, dp[j]);
                }
            }
        }

        int result = 0;
        for (int value : dp) {
            result = Math.max(result, value);
        }

        return result;
    }
}