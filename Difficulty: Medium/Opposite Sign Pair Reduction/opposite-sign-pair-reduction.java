class Solution {
    public ArrayList<Integer> reducePairs(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : arr) {
            boolean add = true;
            while (!res.isEmpty()) {
                int last = res.get(res.size() - 1);
                if ((last >= 0 && num < 0) || (last < 0 && num >= 0)) {
                    if (Math.abs(last) > Math.abs(num)) {
                        add = false;
                        break;
                    } else if (Math.abs(last) < Math.abs(num)) {
                        res.remove(res.size() - 1);
                        continue;
                    } else {
                        res.remove(res.size() - 1);
                        add = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            
            if (add) {
                res.add(num);
            }
        }
        
        return res;
    }
}