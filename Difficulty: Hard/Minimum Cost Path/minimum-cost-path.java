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
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        // Code here
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int dis[][] = new int[n][n];
        for(int temp[]:dis)Arrays.fill(temp,Integer.MAX_VALUE);
        dis[0][0]=grid[0][0];
        pq.add(new int[]{grid[0][0],0,0});
        int dirX[]={-1,1,0,0};
        int dirY[]={0,0,-1,1};
        while(pq.size()!=0){
            int temp[] = pq.poll();
            int d = temp[0];
            for(int k=0;k<4;k++){
                int i = temp[1]+dirX[k];
                int j = temp[2]+dirY[k];
                if(i<n && j<n && i>=0 && j>=0 && d+grid[i][j]<dis[i][j]){
                    dis[i][j] = d+grid[i][j];
                    pq.add(new int[]{d+grid[i][j],i,j});
                }
            }
        }
        return dis[n-1][n-1];
    }

}