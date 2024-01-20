//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.vertexCover(n, m, edges);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    private static int[][] adj;
    private static boolean isPossible(int n, int m, int mid) {
        int set = (1 << mid) - 1;
        int limit = (1 << n);

        while (set < limit) {
            boolean[][] vis = new boolean[n + 1][n + 1];
            int edgeCovered = 0;

            for (int j = 1, u = 1; j < limit; j = j << 1, u++) {
                if ((set & j) != 0) {
                    for (int v = 1; v <= n; v++) {
                        if (adj[u][v] == 1 && !vis[u][v]) {
                            edgeCovered++;
                            vis[u][v] = true;
                            vis[v][u] = true;
                        }
                    }
                }
            }

            if (edgeCovered == m) {
                return true;
            }

            int rightMostSetBit = set & -set;
            int val = set + rightMostSetBit;
            set = (((val ^ set) >> 2) / rightMostSetBit) | val;
        }
        return false;
    }
    public static int vertexCover(int n, int m, int[][] edges) {
        // code here
        adj = new int[n + 1][n + 1];

        for (int[] v : edges) {
            adj[v[0]][v[1]] = 1;
            adj[v[1]][v[0]] = 1;
        }

        int l = 1, r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (isPossible(n, m, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
