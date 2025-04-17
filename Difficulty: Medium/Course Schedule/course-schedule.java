//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt(); // Number of nodes
            int m = sc.nextInt(); // Number of edges

            int x = n;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) adj.add(i, new ArrayList<Integer>());

            int[][] prerequisites = new int[m][2];
            for (int i = 0; i < m; i++) {
                prerequisites[i][0] = sc.nextInt();
                prerequisites[i][1] = sc.nextInt();
                adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }

            ArrayList<Integer> res = new Solution().findOrder(n, prerequisites);

            if (check(adj, x, res) == true)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int n,
                         ArrayList<Integer> res) {

        if (n != res.size()) return false;

        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


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
