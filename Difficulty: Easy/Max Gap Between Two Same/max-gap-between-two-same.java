class Solution {
    public int maxCharGap(String s) {
        // code here
        int n=s.length();
        int i=0;
        int max=Integer.MIN_VALUE;
        while(i<n-1){
            char c1=s.charAt(i);
            int j=n-1;
            if(max>(n-i)) break;
            while(j>i){
                char c2=s.charAt(j);
                if(c1==c2){
                    max=Math.max(max,(j-i-1));
                }
                j--;
            }
            i++;
            
        }
        return max==Integer.MIN_VALUE?-1:max;
    }
};