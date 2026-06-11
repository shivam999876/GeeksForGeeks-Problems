class Solution {
    public int findIndex(String s) {
        int n = s.length();
        
        int open = 0, close = 0;
        for (char ch: s.toCharArray()) {
            if (ch == ')') close++;
        }
        
        for (int i=0; i<=n; i++) {
            if (open == close) return i;
            
            if (i < n) {
                if (s.charAt(i) == '(') open++;
                else close--;
            }
        }
        return -1;
    }
}