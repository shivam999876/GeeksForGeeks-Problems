class Solution {
    int maxSubstring(String s) {
        
        int n = s.length();
        int diff = Integer.MIN_VALUE;
        
        int zeros = 0, ones = 0;
        for (int i=0; i<n; i++) {
            
            if (s.charAt(i) == '0') zeros++;
            else ones++;
            
            if (zeros < ones) zeros = ones = 0;
            else diff = Math.max(diff, zeros - ones);
        }
        
        if (diff < 0) return -1;
        return diff;
    }
}