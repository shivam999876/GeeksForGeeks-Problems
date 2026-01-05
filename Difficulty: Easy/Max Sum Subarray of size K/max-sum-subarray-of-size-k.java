class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int L = 0;
        int currentSum = 0;
        int result = 0;
        for(int R = 0; R < arr.length; R++){
        currentSum += arr[R];
        if(R - L + 1 == k){
            result = Math.max(result, currentSum);
            currentSum -= arr[L];
            L++;
        }
    }
    return result;
    }
}