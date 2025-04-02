//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(mat);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int orangesRotting(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0, time = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) queue.offer(new int[]{i, j});
                else if (mat[i][j] == 1) fresh++;
            }
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int x = cell[0] + dx[d], y = cell[1] + dy[d];
                    if (x >= 0 && x < n && y >= 0 && y < m && mat[x][y] == 1) {
                        mat[x][y] = 2;
                        queue.offer(new int[]{x, y});
                        fresh--;
                    }
                }
            }
            time++;
        }
        
        return fresh == 0 ? time : -1;
    }
}