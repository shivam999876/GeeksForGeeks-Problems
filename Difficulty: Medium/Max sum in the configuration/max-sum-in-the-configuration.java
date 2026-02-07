class Solution {
    int maxSum(int[] arr) {
        // code here
        int n = arr.length;
        int arrSum = 0;
        int curr = 0;
        for(int i = 0; i < n; i++){
            arrSum += arr[i];
            curr += i * arr[i];
        }
        int maxValue = curr;
        for(int i = 1; i < n; i++){
            curr = curr + arrSum - n * arr[n - i];
            maxValue = Math.max(maxValue, curr);
        }
        return maxValue;
    }
}