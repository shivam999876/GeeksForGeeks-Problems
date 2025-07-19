class Solution {
    int fact(int n) {
        if(n == 1) return 1;
        return n * fact(n-1);
    }
    public int vowelCount(String s) {
        int[] map = new int[26];
        for(char ch : s.toCharArray())
            map[ch - 'a']++;
            
        int count = 0;
        for(int i  = 0; i < 26; ++i) {
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20)
                if(map[i] > 0) count++;
        }
        
        if(count == 0) return 0;
        int res = fact(count);
        
        for(int i  = 0; i < 26; ++i) {
            if(i == 0 || i == 4 || i == 8 || i == 14 || i == 20)
                if(map[i] > 0) res *= map[i];
        }
        
        return res;
    }
}