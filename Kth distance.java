class Solution {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code here
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            if(mp.containsKey(arr[i])){
                int diff = i - mp.get(arr[i]);
                if(diff<=k) return true;
            }
            mp.put(arr[i], i);
        }
        return false;
    }
}
