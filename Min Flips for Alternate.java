class Solution {
    public int minFlips(String s) {
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < s.length(); i++) {
            char expected0 = (i % 2 == 0) ? '0' : '1';
            char expected1 = (i % 2 == 0) ? '1' : '0';
            if (s.charAt(i) != expected0) {
                count0++;
            }
            if (s.charAt(i) != expected1) {
                count1++;
            }
        }
        return Math.min(count0, count1);
    }
}
