//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution sol = new Solution();
            ArrayList<Integer> res = sol.intersectionWithDuplicates(a, b);

            // Sort the result
            Collections.sort(res);

            // Print the result
            if (res.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int num : res) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
     public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> mm = new HashMap<>();
        for(int x:a)mm.put(x,1);
        for(int x:b){
            if(mm.get(x)!=null && mm.get(x)!=0){
                ans.add(x);
                mm.put(x,0);
            }
        }
        return ans;
    }
}