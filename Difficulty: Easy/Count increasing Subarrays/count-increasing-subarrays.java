class Solution {
    public int countIncreasing(int[] arr) {
        // code here
        int n = arr.length;
        long ans = 0;
        int count = 0;
        for(int i = 1; i < n; i++){
            if(arr[i] > arr[i - 1]){
                count++;
                ans += count;
            }else{
                count = 0;
            }
        }
        return (int) ans;
    }
}
