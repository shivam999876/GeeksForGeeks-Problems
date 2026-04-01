class Solution {
    int countStrings(int n) {
        // code here
        if (n == 1) return 2;
        int n1 = 2; 
        int n2 = 3; 
        for (int i = 3; i <= n; i++) {
            int c = n1 + n2;
            n1 = n2;
            n2 = c;
        }
        return n2;
    }
}