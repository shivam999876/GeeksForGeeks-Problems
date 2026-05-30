class Solution {
    public void replaceElements(int[] arr) {
        // code here
        int n = arr.length;
        int prev = arr[0];
        for(int i=0;i<n-1;i++){
            int temp=arr[i];
            arr[i] = prev ^ arr[i+1];
            prev = temp;
        }
        arr[n-1] = arr[n-1] ^ prev;
    }
}