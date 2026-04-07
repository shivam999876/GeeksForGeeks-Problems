class Solution {
    public int[] stableMarriage(int[][] men, int[][] women) {
        int n = men.length;
        int[] result = new int[n];
        int[] womanPartner = new int[n];
        Arrays.fill(womanPartner, -1);
        int[] next = new int[n];
        int[][] rank = new int[n][n];
        for (int w = 0; w < n; w++) {
            for (int i = 0; i < n; i++) {
                rank[w][women[w][i]] = i;
            }
        }
        Queue<Integer> freeMen = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            freeMen.add(i);
        }
        while (!freeMen.isEmpty()) {
            int man = freeMen.poll();
            int woman = men[man][next[man]];
            next[man]++;
            if (womanPartner[woman] == -1) {
                womanPartner[woman] = man;
                result[man] = woman;
            } 
            else {
                int currentMan = womanPartner[woman];
                if (rank[woman][man] < rank[woman][currentMan]) {
                    womanPartner[woman] = man;
                    result[man] = woman;
                    freeMen.add(currentMan);
                } 
                else {
                    freeMen.add(man);
                }
            }
        }
        return result;
    }
}