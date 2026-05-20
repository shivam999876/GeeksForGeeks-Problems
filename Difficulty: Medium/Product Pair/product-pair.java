class Solution {
    public boolean isProduct(int[] arr, long target) {
        Set<Long> seen = new HashSet<>();
        for (int num : arr) {
            if (num == 0) {
                if (target == 0 && !seen.isEmpty()) {
                    return true;
                }
            } 
            else if (target % num == 0) {
                long complement = target / num;
                if (seen.contains(complement)) {
                    return true;
                }
            }
            seen.add((long) num);
        }
        return false;
    }
}