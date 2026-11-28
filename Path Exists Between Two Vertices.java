class Solution {
    public void dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean[] visited){
        visited[node] = true;
        for(int nei : adj.get(node)){
            if(!visited[nei]){
                dfs(nei , adj , visited);
            }
        }
    }
    public boolean checkPath(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        // code here
        boolean[] visited = new boolean[adj.size()+1];
        dfs(u , adj , visited);
        return visited[v] == true;
    }
}
