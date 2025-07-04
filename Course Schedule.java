//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        // add your code here
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
            for (int i = 0; i < prerequisites.size(); i++) {
            int course = prerequisites.get(i).get(0);
            int prerequisiteForCourse = prerequisites.get(i).get(1);
            graph[prerequisiteForCourse].add(course);
        }
        
        int[] inDegree = new int[n];
        calcIndgree(graph, inDegree);
        Queue<Integer> queue = new LinkedList<>();
        
        
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int answer[] = new int[n];
        int index=0;
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            answer[index++]=curr;

            for (int i = 0; i < graph[curr].size(); i++) {
                int e = graph[curr].get(i);
                inDegree[e]--;

                if (inDegree[e] == 0) {
                    queue.add(e);
                }
            }
        }
        
              for(int i = 0; i < n; i++) {
            if (inDegree[i] > 0) {
                return new int[0]; //if cycle exists
            }
        }

        return answer;
    }
    
        static void calcIndgree(ArrayList<Integer> graph[], int indegree[]) {
        for (int i = 0; i < indegree.length; i++) {
            int vertex = i;
            for (int j = 0; j < graph[vertex].size(); j++) {
                int e = graph[vertex].get(j);
                indegree[e]++;
            }
        }
    }
}
