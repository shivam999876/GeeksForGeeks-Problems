class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        // code here
        if (m * k > arr.length) {
            return -1;
        }
        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(arr, k, m, mid)) {
                result = mid; 
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return result;
    }
    private static boolean canMakeBouquets(int[] arr, int k, int m, int days) {
        int bouquets = 0; 
        int consecutive = 0; 

        for (int bloomDay : arr) {
            if (bloomDay <= days) {
                consecutive++;
                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0; 
                }
            } else {
                consecutive = 0; 
            }
            if (bouquets >= m) {
                return true; 
            }
        }
        return false;
    }
}