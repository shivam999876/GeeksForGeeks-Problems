class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        int n = arr.length;
        int left = 0, result = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int right = 0; right < n; right++){
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);
            while(freqMap.size() > k){
                freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
                if(freqMap.get(arr[left]) == 0){
                    freqMap.remove(arr[left]);
                }
                left++;
            }
            result += (right - left + 1);
        }
        return result;
    }
}
