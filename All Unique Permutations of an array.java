//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int i=0; i<n; i++)
                arr.add(Integer.parseInt(S[i]));

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> res = ob.uniquePerms(arr,n);
            for(int i=0; i<res.size(); i++)
            {
                for(int j=0; j<n; j++)
                {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<Integer>> uniquePerms(ArrayList<Integer> arr, int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[n];

        // Sort the input array to handle duplicates
        Collections.sort(arr);

        generatePermutations(arr, n, currentPermutation, used, result);

        return result;
    }

    static void generatePermutations(ArrayList<Integer> arr, int n, ArrayList<Integer> currentPermutation,
                                     boolean[] used, ArrayList<ArrayList<Integer>> result) {
        if (currentPermutation.size() == n) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < n; i++) {
            // Skip if the element is already used or if it's a duplicate
            if (used[i] || (i > 0 && arr.get(i) == arr.get(i - 1) && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            currentPermutation.add(arr.get(i));

            generatePermutations(arr, n, currentPermutation, used, result);

            used[i] = false;
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }
}
