class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
          int maxLeftDistance = 0;
        for (int position : left) {
            maxLeftDistance = Math.max(maxLeftDistance, position);
        }
        int maxRightDistance = 0;
        for (int position : right) {
            maxRightDistance = Math.max(maxRightDistance, n - position);
        }
        return Math.max(maxLeftDistance, maxRightDistance);
    }
}