class Solution {
    public String lexicographicallySmallest(String s, int k) {
        int n = s.length();
        if ((n & (n - 1)) == 0) {
            k = k / 2;
        } else {
            k = k * 2;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (ans.length() > 0
                    && ans.charAt(ans.length() - 1) > s.charAt(i)
                    && k > 0) {
                ans.deleteCharAt(ans.length() - 1);
                k--;
            }
            ans.append(s.charAt(i));
        }
        while (ans.length() > 0 && k > 0) {
            ans.deleteCharAt(ans.length() - 1);
            k--;
        }
        if (ans.length() == 0) {
            return "-1";
        }
        return ans.toString();
    }
}