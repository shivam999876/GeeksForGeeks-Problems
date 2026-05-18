class Solution {
    public int maxSum(int n) {
        // code here.
        if(n==0 || n==1)
        return n;
        int a = (int)maxSum(n/2);
        int b =(int)maxSum(n/3);
        int c =(int)maxSum(n/4);
        int ans =(a+b+c);
        return Math.max(ans,n);
    }
}
