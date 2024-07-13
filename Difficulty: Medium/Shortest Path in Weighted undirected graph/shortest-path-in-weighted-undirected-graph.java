//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]), m = Integer.parseInt(s[1]);
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                s = br.readLine().trim().split(" ");
                edges[i][0] = Integer.parseInt(s[0]);
                edges[i][1] = Integer.parseInt(s[1]);
                edges[i][2] = Integer.parseInt(s[2]);
            }

            List<Integer> list = new Solution().shortestPath(n, m, edges);

            ot.println(list.get(0));
            if (list.get(0) != -1 && !check(list, edges)) ot.println(-1);
        }
        ot.close();
    }

    static boolean check(List<Integer> list, int edges[][]) {
        Set<Integer> hs = new HashSet<>();
        Map<Integer, Map<Integer, Integer>> hm = new HashMap<>();
        for (int i = 1; i < list.size(); i++) hs.add(list.get(i));
        for (int x[] : edges) {
            if (hs.contains(x[0]) || hs.contains(x[1])) {
                if (!hm.containsKey(x[0])) hm.put(x[0], new HashMap<>());
                if (!hm.containsKey(x[1])) hm.put(x[1], new HashMap<>());
                hm.get(x[0]).put(x[1], x[2]);
                hm.get(x[1]).put(x[0], x[2]);
            }
        }
        int sum = 0;
        for (int i = 1; i < list.size() - 1; i++) {
            if (!hm.containsKey(list.get(i)) ||
                !hm.get(list.get(i)).containsKey(list.get(i + 1)))
                return false;
            sum += hm.get(list.get(i)).get(list.get(i + 1));
        }
        return sum == list.get(0);
    }
}

// } Driver Code Ends


class Solution {
    class Data{
        int nbr;
        int wgt;
        Data(int nbr,int wgt){
            this.nbr=nbr;
            this.wgt=wgt;
        }
    }
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<Data>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int e[]:edges){
            adj.get(e[0]).add(new Data(e[1],e[2]));
            adj.get(e[1]).add(new Data(e[0],e[2]));
        }
        
        return dijkstra(n,adj);
    }
    
    List<Integer> dijkstra(int n,List<List<Data>> adj){
        int w[] = new int[n+1];
        int par[] = new int[n+1];
        Arrays.fill(w,Integer.MAX_VALUE);
        w[1]=0;
        par[1]=1;
        
        //vtx,wgt
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        pq.add(new int[]{1,0});
        
        while(!pq.isEmpty()){
            int pop[] = pq.remove();
            int cur_node = pop[0], cur_wgt = pop[1];
            
            for(Data nbr_nodes:adj.get(cur_node)){
                int nbr_node = nbr_nodes.nbr, nbr_wgt = nbr_nodes.wgt;
                
                if(cur_wgt+nbr_wgt<w[nbr_node]){
                    w[nbr_node] = cur_wgt+nbr_wgt;
                    par[nbr_node] = cur_node;
                    pq.add(new int[]{nbr_node,w[nbr_node]});
                }
            }
        }
        
        
        if(w[n]==Integer.MAX_VALUE){
            List<Integer> ans = new ArrayList<>();
            ans.add(-1);
            return ans;
        }
        
        // for(int i:w){
        //     System.out.print(i+" ");
        // }
        // System.out.println();
        List<Integer> ans = new ArrayList<>();
        ans.add(w[n]);
        
        int node = n;
        while(par[node]!=node){
            ans.add(node);
            node = par[node];
        }
        ans.add(node);
        
        return ans;
    }
}