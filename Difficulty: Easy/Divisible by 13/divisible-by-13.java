class Solution {
    public boolean divby13(String s) {
        // code here
          if (s == null || s.isEmpty()) {
            return false; 
        }

        int remainder = 0;
        for (int i = 0; i < s.length(); i++) {
            char digitChar = s.charAt(i);
            int digit = digitChar - '0'; 
            remainder = (remainder * 10 + digit) % 13;
        }

        return remainder == 0;
    }
}