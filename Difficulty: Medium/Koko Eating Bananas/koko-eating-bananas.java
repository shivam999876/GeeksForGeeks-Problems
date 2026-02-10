class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int l=1,r=arr[0];
        for(int i:arr) r=Math.max(r,i);
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canEat(arr,mid,k)) r=mid-1;
            else l=mid+1;
        }
        return l;
    }
    private boolean canEat(int arr[],int bph,int k){
        int hours=0;
        for(int i:arr){
            if(i<=bph) hours++;
            else hours+=Math.ceil((double)i/(double)bph);
        }
        return hours<=k;
    }
}