class Solution {
    int longestSubarrayDivK(int[] arr, int k) {
        int ans = 0, sum = 0;
        int[] firstSeen = new int[k];
        Arrays.fill(firstSeen, -2);
        firstSeen[0] = -1; 
        for (int i = 0; i < arr.length; i++) {
            sum = ((sum + arr[i]) % k + k) % k;
            if (firstSeen[sum] != -2) {
                ans = Math.max(ans, i - firstSeen[sum]);
            } else {
                firstSeen[sum] = i;
            }
        }
        return ans;
    }
}
