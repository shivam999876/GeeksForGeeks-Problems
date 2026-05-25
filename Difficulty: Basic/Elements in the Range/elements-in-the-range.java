class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        // code 
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        for(int i=start;i<=end;i++){
            if(!set.contains(i)){
                return false;
            }
        }
        return true;
    }
}