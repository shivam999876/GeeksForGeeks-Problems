class Solution {
    public static int countPairs(int arr[], int k) {
        // code here
        Arrays.sort(arr);
        int i = 0, cnt = 0;
        for(int j = 0; j < arr.length; j++){
            while(arr[j] - arr[i] >= k){
                i++;
            }
            cnt += (j -i);
        }
        return cnt;
    }
}
