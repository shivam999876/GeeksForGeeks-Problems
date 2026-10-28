class Solution {
    public char nthCharacter(int n) {
        long len = 0;
        long digits = 1;
        long count = 9;
        
        while (n > len + digits * count) {
            len += digits * count;
            digits++;
            count *= 10;
        }
        
        long remaining = n - len - 1;
        long num = (long) Math.pow(10, digits - 1) + remaining / digits;
        long index = remaining % digits;
        
        return String.valueOf(num).charAt((int) index);
    }
}
