class Solution {
    void segregate0and1(int[] arr) {
        // code here
        int zero=0,one=arr.length-1;
        while(zero<one){
            if(arr[zero]==1){
                int temp = arr[zero];
                arr[zero] = arr[one];
                arr[one] = temp;
                one--;
            }
            else zero++;
        }
    }
}
