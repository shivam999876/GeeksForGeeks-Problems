class Solution {
    public int getMinimumDays(String s, int[] p) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int mismatchCount = 0;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                mismatchCount++;
            }
        }

        if (mismatchCount == 0) {
            return 0;
        }

        for (int day = 0; day < n; day++) {
            int idx = p[day];
            
            if (idx > 0 && arr[idx] == arr[idx - 1]) {
                mismatchCount--;
            }
            if (idx < n - 1 && arr[idx] == arr[idx + 1]) {
                mismatchCount--;
            }
            
            arr[idx] = '?';

            if (mismatchCount == 0) {
                return day + 1;
            }
        }

        return 0;
    }
}
