class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        // code here
        int arr[][] = new int[3][2];
        arr[0] = new int[]{s,cs};
        arr[1] = new int[]{m,cm};
        arr[2] = new int[]{l,cl};
        return solve(0,0, x, arr);
    }
    int solve(int ind, int curr, int tar, int[][] arr)
    {
        if(curr>= tar){
            return 0;
        }
        if(ind>=3){
            return (int) 1e9;
        }
        int take=0, notake=0;
        take = arr[ind][1]+solve(ind, curr+arr[ind][0], tar, arr);
        notake = solve(ind+1, curr, tar, arr);
        return Math.min(take, notake);
    }
}
