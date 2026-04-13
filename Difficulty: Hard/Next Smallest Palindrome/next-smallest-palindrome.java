class Solution {
    public static int[] nextPalindrome(int[] digits) {
        int length = digits.length;
        boolean isAllNines = true;
        for (int digit : digits) {
            if (digit != 9) {
                isAllNines = false;
                break;
            }
        }
        if (isAllNines) {
            int[] result = new int[length + 1];
            result[0] = 1;
            result[length] = 1;
            return result;
        }
        int[] candidate = Arrays.copyOf(digits, length);
        int midPoint = length / 2;

        for (int i = 0; i < midPoint; i++) {
            candidate[length - 1 - i] = candidate[i];
        }
        if (isCandidateSmallerOrEqual(candidate, digits)) {
            int leftIdx = (length % 2 == 0) ? midPoint - 1 : midPoint;
            int carry = 1;
            while (leftIdx >= 0 && carry > 0) {
                candidate[leftIdx] += carry;
                carry = candidate[leftIdx] / 10;
                candidate[leftIdx] %= 10;
                candidate[length - 1 - leftIdx] = candidate[leftIdx];
                leftIdx--;
            }
        }
        return candidate;
    }
    private static boolean isCandidateSmallerOrEqual(int[] candidate, int[] original) {
        for (int i = 0; i < candidate.length; i++) {
            if (candidate[i] < original[i]) return true;
            if (candidate[i] > original[i]) return false;
        }
        return true;
    }
}