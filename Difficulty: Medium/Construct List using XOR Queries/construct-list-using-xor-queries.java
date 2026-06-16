class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        // code here
        int q = queries.length;
        int[] DAT = new int[q + 1];
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        int currResultSize = 1;
        for(int[] query : queries){
            int opr = query[0];
            int x = query[1];
            if(opr == 0){
                result.add(x);
                currResultSize++;
            }else{
                DAT[0] ^= x;
                DAT[currResultSize] ^= x;
            }
        }
        int runningXOR = 0;
        for(int i = 0 ; i < currResultSize ; i++){
            runningXOR ^= DAT[i];
            int nexXORval = runningXOR ^ result.get(i);
            result.set(i , nexXORval);
        }
        Collections.sort(result);
        return result;
    }
}