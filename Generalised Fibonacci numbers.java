//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            long a = Long.parseLong(S[0]);
            long b = Long.parseLong(S[1]);
            long c = Long.parseLong(S[2]);
            long n = Long.parseLong(S[3]);
            long m = Long.parseLong(S[4]);

            Solution ob = new Solution();
            System.out.println(ob.genFibNum(a,b,c,n,m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {

    public static long genFibNum(Long a, Long b, Long c, long n, long m) {
        long[][] res = new long[3][3];
        long[][] mat = new long[3][3];

        for (long[] row : res) {
            Arrays.fill(row, 0);
        }

        res[0][0] = res[1][1] = res[2][2] = 1;

        mat[0][0] = a;
        mat[0][1] = b;
        mat[0][2] = mat[1][0] = mat[2][2] = 1;
        mat[1][1] = mat[1][2] = mat[2][0] = mat[2][1] = 0;

        if (n <= 2) {
            return 1 % m;
        } else {
            matExp(mat, res, n - 2, m);
            return (res[0][0] + res[0][1] + c * res[0][2]) % m;
        }
    }

    private static void matMul(long[][] res, long[][] mat, long m) {
        long[][] res1 = new long[3][3];

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                for (int k = 0; k < 3; ++k) {
                    res1[i][j] += (res[i][k] * mat[k][j]) % m;
                    res1[i][j] %= m;
                }
            }
        }

        for (int i = 0; i < 3; ++i) {
            System.arraycopy(res1[i], 0, res[i], 0, 3);
        }
    }

    private static void matExp(long[][] mat, long[][] res, long n, long m) {
        while (n > 0) {
            if ((n & 1) == 1) {
                matMul(res, mat, m);
            }
            matMul(mat, mat, m);
            n /= 2;
        }
    }
    public static void main(String[] args) {
        Long a = 1L, b = 1L, c = 1L;
        long n = 5, m = 1000000007;
        long result = genFibNum(a, b, c, n, m);
        System.out.println("Fibonacci number modulo " + m + " for n = " + n + ": " + result);
    }
}
