class Solution {
    private static final long MOD = 1000000007L;

    private long ceilDiv(long x, long y) {
        if (x >= 0) {
            return (x + y - 1) / y;
        }
        return x / y;
    }

    private long getTime(long x, long a, long b) {
        long c = a - b;
        long k = Math.max(0L, ceilDiv(x - a, c));
        return x + 2L * b * k;
    }

    private long sumK(long L, long R, long a, long c) {
        if (L > R) return 0;

        long ans = 0;
        for (long rem = 0; rem < c; rem++) {
            long first = L + (rem - (L % c) + c) % c;
            if (first > R) continue;

            long cnt = (R - first) / c + 1;
            long t = (first - rem) / c;
            long offset = ceilDiv(rem - a, c);

            long sumT = cnt * (2L * t + cnt - 1) / 2;
            ans += sumT + cnt * offset;
        }
        return ans;
    }

    public int minTime(int a, int b, int d, int l, int r) {
        long normal = getTime(d, a, b);

        long L = (long) d - r;
        long R = (long) d - l;

        long low = L, high = R;
        long p = L - 1;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (1 + getTime(mid, a, b) <= normal) {
                p = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        long ans = 0;

        if (L <= p) {
            long cnt = p - L + 1;
            long sumX = (L + p) * cnt / 2;
            long sumCycles = sumK(Math.max(L, (long) a + 1), p, a, (long) a - b);

            ans = (ans + cnt + sumX + 2L * b * sumCycles) % MOD;
        }

        if (p < R) {
            long cnt = R - Math.max(L, p + 1) + 1;
            ans = (ans + (cnt % MOD) * (normal % MOD)) % MOD;
        }

        return (int) (ans % MOD);
    }
}
