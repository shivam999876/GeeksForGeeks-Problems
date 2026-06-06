class Solution {
    public long numOfWays(int n, int m) {

        long cells = 1L * n * m;

        long totalWays = cells * (cells - 1);

        long attackingWays = 4L *
                ((long)(n - 1) * Math.max(0, m - 2)
                + (long)Math.max(0, n - 2) * (m - 1));

        return totalWays - attackingWays;
    }
}