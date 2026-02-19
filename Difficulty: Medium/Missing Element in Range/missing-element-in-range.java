class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
        HashSet<Integer>hset = new HashSet<>();
        for(int i :arr) hset.add(i);
        ArrayList<Integer>list = new ArrayList<>();
        for(int i=low;i<=high;i++)
        {
            if(!hset.contains(i)) list.add(i);
        }
        return list;
    }
}