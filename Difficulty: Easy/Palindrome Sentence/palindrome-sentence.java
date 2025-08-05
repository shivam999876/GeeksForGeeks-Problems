class Solution {
    public boolean isPalinSent(String s) {
        // code here
         StringBuilder s1 = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                s1.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder rev = new StringBuilder(s1.toString());
        rev.reverse();
        return s1.toString().equals(rev.toString());
    }
}