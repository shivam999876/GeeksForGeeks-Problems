//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        nextQ(n, new int[n], 0, res);
        return res;
    }
    
    public void nextQ(int n, int[] curr, int done, ArrayList<ArrayList<Integer>> res) {
        if(done == n) {
            ArrayList<Integer> intList = new ArrayList<Integer>(curr.length);
            for (int i : curr)
                intList.add(i+1);
            res.add(intList);
            return;
        }
        for(int i=0; i<n; i++) {
            boolean rejected = false;
            for(int j=0; j<done && !rejected; j++) { 
                if(i == curr[j] || Math.abs(curr[j]-i) == (done - j)) {
                    rejected = true;
                    break;
                }
            }
            if(!rejected) {
                curr[done] = i;
                nextQ(n, curr, done + 1, res);
            }
        }
    }
}