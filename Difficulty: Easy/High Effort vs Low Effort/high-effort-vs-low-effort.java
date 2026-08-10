class Solution {
    public int maxTask(int[] h, int[] l) {
        // code here
         int len=h.length;
        int[] dp=new int[len+2];
        for(int i=0;i<len;i++){
            dp[i+2]=Math.max(h[i]+dp[i],l[i]+dp[i+1]);
        }
        return dp[len+1];
    }
}