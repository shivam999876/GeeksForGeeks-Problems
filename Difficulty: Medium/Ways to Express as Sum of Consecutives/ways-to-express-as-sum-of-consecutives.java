class Solution {
    public int getCount(int n) {
        // code here
        int sum=0,cnt=0,x=1;
        for(int r=1;r<=n;r++){
            if(sum==n) cnt++;
            sum+=r;
            while(sum>n){
                sum-=x;
                x+=1;
            }
        }
        return cnt;
    }
};