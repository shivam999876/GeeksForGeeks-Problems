class Solution {
    int smallestDivisor(int[] arr, int k) {
        // Code here
        int divisor = arr[0];
        for(int i : arr){
            if(i > divisor){
                divisor = i;
            }
        }
        int i = 0;
        int j = divisor;
        while(i <= j){
            int mid = (i + j) / 2;
            int sum = 0;
            for(int a = 0;a<arr.length; a++){
                sum += Math.ceil(arr[a]/(double)mid);
            }
            if(sum <= k){
                divisor = mid;
                j = mid - 1;
            }
            else{
                i = mid + 1;
            }
        }
        return divisor;
    }
}