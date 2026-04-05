class Solution {
    public int totalWays(int[] arr, int target) {
        // code here
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        if (target > total || target < -total || (target + total) % 2 != 0) {
            return 0;
        }
        int P = (target + total) / 2;
        int[] dp = new int[P + 1];
        dp[0] = 1;
        for (int num : arr) {
            for (int j = P; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[P];
    }
}