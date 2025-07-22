
class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Your code here
        
        Set<Integer>set = new HashSet<>();
        int max = 0;
        
        for(int e : arr){
            max = Math.max(max, e);
            set.add(e);
        }
        
        for(int i = 1; i<max; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return max+1;
    }
}