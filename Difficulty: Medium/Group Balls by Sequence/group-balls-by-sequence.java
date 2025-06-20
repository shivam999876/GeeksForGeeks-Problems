class Solution {
    public boolean validgroup(int[] arr, int k) {
        // code here
        int n = arr.length;
        if(k == 1) return true;
        if(n % k != 0) return false;
        Arrays.sort(arr);
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num : arr){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
            for(int i = 0; i < n; i++){
                int count = freqMap.get(arr[i]);
                if(count == 0) continue;
                freqMap.put(arr[i], count - 1);
                for(int offset = 1; offset < k; offset++){
                    int next = arr[i] + offset;
                    if(freqMap.getOrDefault(next, 0) == 0){
                        return false;
                    }
                    freqMap.put(next, freqMap.get(next) - 1);
                }
            }
            return true;
        }
    }