//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            out.println(ob.kthSmallest(arr, key));
        }
        out.flush();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
   public static int kthSmallest(int[] arr, int k) {
        // Your code here
        int mx = Integer.MIN_VALUE;
        for(int x:arr)mx=Math.max(x,mx);
        int hash[] = new int[mx+1];
        Arrays.fill(hash,0);
        for(int x:arr)hash[x]=1;
        for(int i=1;i<=mx;i++){
            k-=hash[i];
            if(k==0)return i;
        }
        return 0;
    }
}
