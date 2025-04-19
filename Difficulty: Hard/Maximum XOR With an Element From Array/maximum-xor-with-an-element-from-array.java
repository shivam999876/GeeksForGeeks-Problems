//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        // Create BufferedReader and StringTokenizer for fast input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // Read the number of test cases
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read the array in a single line
            st = new StringTokenizer(br.readLine());
            int n = st.countTokens();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // Read the number of queries
            int q = Integer.parseInt(br.readLine());

            // Read queries
            int[][] queries = new int[q][2];
            for (int i = 0; i < q; i++) {
                st = new StringTokenizer(br.readLine());
                queries[i][0] = Integer.parseInt(st.nextToken());
                queries[i][1] = Integer.parseInt(st.nextToken());
            }

            // Call the Solution class to get the result
            Solution obj = new Solution();
            int[] ans = obj.maxXor(arr, queries);

            // Output the result
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    private void insert(TrieNode root, int num) {
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (root.children[bit] == null) {
                root.children[bit] = new TrieNode();
            }
            root = root.children[bit];
        }
    }

    private int getMaxXor(TrieNode root, int num) {
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (root.children[1 - bit] != null) {
                xor |= (1 << i);
                root = root.children[1 - bit];
            } else {
                root = root.children[bit];
            }
        }
        return xor;
    }

    public int[] maxXor(int[] arr, int[][] queries) {
        Arrays.sort(arr);
        int n = queries.length;
        int[][] indexedQueries = new int[n][3];
        for (int i = 0; i < n; i++) {
            indexedQueries[i][0] = queries[i][0];
            indexedQueries[i][1] = queries[i][1];
            indexedQueries[i][2] = i;
        }
        Arrays.sort(indexedQueries, Comparator.comparingInt(a -> a[1]));

        int[] ans = new int[n];
        TrieNode root = new TrieNode();
        int idx = 0;
        for (int[] q : indexedQueries) {
            int xi = q[0], mi = q[1], qIndex = q[2];
            while (idx < arr.length && arr[idx] <= mi) {
                insert(root, arr[idx]);
                idx++;
            }
            if (idx == 0) {
                ans[qIndex] = -1;
            } else {
                ans[qIndex] = getMaxXor(root, xi);
            }
        }
        return ans;
    }
}
