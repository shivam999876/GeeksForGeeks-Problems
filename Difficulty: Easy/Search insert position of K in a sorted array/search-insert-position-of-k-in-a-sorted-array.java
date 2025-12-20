class Solution {
    public int searchInsertK(int arr[], int k) {
        // code here
        int low = 0, high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == k)
                return mid;
            else if(arr[mid] < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }
};