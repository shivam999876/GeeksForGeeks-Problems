class Solution {
    public int minimumSum(String s) {
        // code here
        int n = s.length();
        int sum = 0;
        char prev = '?';
        for(int i = 0; i < n; i++){
            int j = n - 1 - i;
            char here = s.charAt(i);
            char mirror = s.charAt(j);
            if(i < j && here != '?' && mirror != '?' && here != mirror)
                return -1;
            char c = here != '?' ? here : mirror;
            if(c == '?')
                continue;
            if(prev != '?')
                sum += Math.abs(c - prev);
            prev = c;
        }
        return sum;
    }
}
