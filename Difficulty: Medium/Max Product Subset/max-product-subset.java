class Solution {
    public int findMaxProduct(int[] arr) {
        final int MOD = (int) 1e9 + 7;
        int negCount = 0, posCount = 0, zeroCount = 0;
        int minAbsNeg = Integer.MAX_VALUE;
        for (int x : arr) {
            if (x > 0) {
                posCount++; 
            }else if (x < 0) {
                negCount++;
                minAbsNeg = Math.min(minAbsNeg, -x);
            } else {
                zeroCount++;
            }
        }
        if (negCount == 0 && posCount == 0) {
            return 0;
        }
        if (negCount == 1 && posCount == 0) {
            if (zeroCount > 0) {
                return 0;
            }
            for (int x : arr) {
                if (x < 0) {
                    return x;
                }
            }
        }
        boolean skipped = false;
        long pro = 1;
        for (int x : arr) {
            if (x == 0) {
                continue;
            }
            if (!skipped && negCount % 2 == 1 && x < 0 && -x == minAbsNeg) {
                skipped = true;
                continue;
            }
            pro = pro * Math.abs(x) % MOD;
        }
        return (int) pro;
    }
}