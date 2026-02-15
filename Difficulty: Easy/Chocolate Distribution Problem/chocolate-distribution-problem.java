// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        Collections.sort(arr);
        int ans = Integer.MAX_VALUE;
        int n = arr.size();
        int min = Integer.MAX_VALUE;
        if(m > n) return 0;
        if(m == n) return arr.get(m - 1) - arr.get(0);
        for(int i = 0; i < n - m + 1; i++){
            min = arr.get(i + m - 1) - arr.get(i);
            ans = Math.min(min, ans);
        }
        return ans;
    }
}