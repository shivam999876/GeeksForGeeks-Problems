class Solution {
    public int minSubarraySum(int[] arr) {
        // code here
        int curr = arr[0];
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
        curr = Math.min(arr[i], curr + arr[i]);
        ans = Math.min(ans, curr);
        }
        return ans;
    }
}
