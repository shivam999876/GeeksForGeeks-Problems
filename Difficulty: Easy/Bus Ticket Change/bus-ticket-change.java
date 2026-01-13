class Solution {
    public boolean canServe(int[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 5){
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            else if(arr[i] == 10){
                if(map.containsKey(5) && map.get(5) >= 1){
                    map.put(5, map.get(5) - 1);
                    map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                }
                else return false;
            }
            else if(arr[i] == 20){
                if(map.containsKey(5) && map.containsKey(10) && map.get(5) >= 1 && map.get(10) >= 1){
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.get(10) - 1);
                }
                else if(map.containsKey(5) && map.get(5) >= 3){
                    map.put(5, map.get(5) - 3);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}