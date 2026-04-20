class Solution {
     static int[] d = new int[13];
    static {
        d[0] = 1;
        d[1] = 0;
        
        for(int i = 2; i <= 12; i++) {
            d[i] = (i - 1) * ((d[i - 1] + d[i - 2]));
        }
    }
    public int derangeCount(int n) {
        // code here
        return d[n];
    }
};