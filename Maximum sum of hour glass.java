//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int Mat[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    Mat[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.findMaxSum(N, M, Mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMaxSum(int x, int y, int m[][]) {
        // code here
        if(x<=2 || y<=2 ) return -1;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<x-2; i++){
            for(int j=0; j<y-2; j++){
                int sum = m[i][j] + m[i][j+1] + m[i][j+2]
                + m[i+1][j+1] + m[i+2][j] + m[i+2][j+1] + m[i+2][j+2];

                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }
};
