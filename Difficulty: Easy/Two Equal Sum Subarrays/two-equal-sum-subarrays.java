class Solution {
    public boolean canSplit(int arr[]) {
        // code here
         int len = arr.length;
        long sum = 0;
        for(int i =0;i<len;i++){
            sum += arr[i];
        }
        long tempSum =0;
        for(int  i=0;i<len ; i++){
            
            tempSum += arr[i];
            if(tempSum == (sum - tempSum))
            return true;
        }
        return false;
    }
}