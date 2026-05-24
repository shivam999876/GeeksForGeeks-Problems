class Solution {
    public int coin(int[] arr) {
       int min=Integer.MAX_VALUE;
       
       for(int i:arr) min=Math.min(i,min);
       
       return min;
    }
}