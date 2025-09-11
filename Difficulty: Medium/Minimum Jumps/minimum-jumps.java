class Solution {
    public int minJumps(int[] arr) {
        // code here
        int n = arr.length;
        if(n == 0 || arr[0] == 0){
            return -1;
        }
        if(n == 1){
            return 0;
        }
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        for(int i = 0; i < n - 1; i++){
            farthest = Math.max(farthest, i + arr[i]);
            if(i == currentEnd){
                jumps++;
                currentEnd = farthest;
                if(currentEnd >= n - 1){
                    return jumps;
                }
            }
        }
        return -1;
    }
}