//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.detectCycle(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution
{
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
         unionFind uf=new unionFind(V);
        Set<String>set=new HashSet<>();
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                if(set.contains(helper(i,it))){
                    continue;
                }
                if(uf.findParent(i)!=uf.findParent(it)){
                    uf.union(i,it);
                    set.add(helper(i,it));
                    set.add(helper(it,i));
                }
                else{
                    return 1;
                }
            }
        }
        return 0;
    }
    class unionFind{
        int parent[];
        int rank[];
        public unionFind(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
            parent[i]=i;
            }
            Arrays.fill(rank,0);
        }
        public void union(int a,int b){
            int ulp_a=findParent(a);
            int ulp_b=findParent(b);
            if(ulp_a==ulp_b){
                return ;
            }
            else if(ulp_a>ulp_b){
                parent[ulp_b]=ulp_a;
            }
            else{
                parent[ulp_a]=ulp_b;
            }
        }
        int findParent(int a){
            if(parent[a]==a){
                return parent[a];
            }
            return parent[a]=findParent(parent[a]);
        }
    }
    public String helper(int a,int b){
        String ans=Integer.toString(a);
        ans+=Integer.toString(b);
        return ans;
    }
}
