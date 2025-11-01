



class Solution {
    public static ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            adj.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);

            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (result.size() == n) return result;
        return new ArrayList<>();
    }
}
