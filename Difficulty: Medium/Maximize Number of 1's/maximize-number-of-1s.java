class Solution {
    public int maxOnes(int arr[], int k) {
        // code here
        int left = 0, right = 0, maxOnes = 0, zeroCount = 0;

        while (right < arr.length) {
            if (arr[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxOnes = Math.max(maxOnes, right - left + 1);
            right++;
        }

        return maxOnes;
    }
}