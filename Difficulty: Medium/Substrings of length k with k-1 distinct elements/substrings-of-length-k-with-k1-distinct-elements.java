class Solution {
    public int substrCount(String s, int k) {
        // code here
        int n = s.length();
        int count = 0;
        for(int i = 0; i <= n - k; i++){
            int[] freq = new int[26];
            int distinct = 0;
            for(int j = i; j < i + k; j++){
                freq[s.charAt(j) - 'a']++;
                if(freq[s.charAt(j) - 'a'] == 1){
                    distinct++;
                }
            }
            if(distinct == k - 1){
                count++;
            }
        }
        
        return count;
    }
}