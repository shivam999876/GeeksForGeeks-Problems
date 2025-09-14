class Solution {
    public int startStation(int[] gas, int[] cost) {
        // code here
          int n = cost.length;
        int balance = 0, deficit = 0, start = 0;
        
        for(int i=0; i<n; i++) {
            balance += (gas[i] - cost[i]);
            
            if(balance < 0) {
                deficit += balance;
                balance = 0;
                start = i + 1;
            }
        }
        
        if(balance + deficit >= 0) {
            return start;
        }
        
        return -1;
    }
}