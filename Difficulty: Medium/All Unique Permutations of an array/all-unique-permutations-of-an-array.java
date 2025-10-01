class Solution {
    static ArrayList<ArrayList<Integer>> ans; 
    public static ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        // code here
        int n = arr.length;
        ans = new ArrayList<>();
        Arrays.sort(arr);
        boolean vis[] = new boolean[n];
        backtrack(arr, vis, new ArrayList<>());
        return ans;
    }
    static void backtrack(int arr[], boolean vis[], List<Integer> path){
        if(path.size() == arr.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(vis[i]) continue;
            if(i > 0 && arr[i] == arr[i - 1] && !vis[i - 1]) continue;
            vis[i] = true;
            path.add(arr[i]);
            backtrack(arr, vis, path);
            path.remove(path.size() - 1);
            vis[i] = false;
        }
    }
};