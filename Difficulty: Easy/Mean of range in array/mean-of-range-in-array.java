class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        // code here
          ArrayList<Integer> res = new ArrayList<>();
        int sum[] = new int[arr.length];
        sum[0] = arr[0];
        
        for (int i=1; i<arr.length; i++){
            sum[i] = sum[i-1] + arr[i];
        }
        
        for (int i=0; i<queries.length; i++){
                
            int l = queries[i][0];  
            int r = queries[i][1];  
            
            int total = sum[r] - (l>0 ? sum[l-1] : 0);
            int count = (r+1)-l;
            res.add(total / count);
        }
        return res;
    }
}