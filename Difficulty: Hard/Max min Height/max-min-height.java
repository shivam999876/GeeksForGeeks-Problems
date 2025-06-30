class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        // code here
        int n = arr.length;
        int low = getMin(arr);
        int high = low + k;
        int answer = low;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(isPossible(arr, k, w, mid)){
                answer = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return answer;
    }
    private boolean isPossible(int[] arr, int k, int w, int targetHeight){
        int n = arr.length;
        int[] diff = new int[n + w + 1];
        long totalUsed = 0;
        long added = 0;
        for(int i = 0; i < n; i++){
            added += diff[i];
            int currentHeight = arr[i] + (int)added;
            if(currentHeight < targetHeight){
                int need = targetHeight - currentHeight;
                totalUsed += need;
                if(totalUsed > k) return false;
                diff[i] += need;
                diff[i + w] -= need;
                added += need;
            }
        }
        return true;
    }
    private int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int num : arr){
            min = Math.min(min, num);
        }
        return min;
    }
}