//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            Solution ob = new Solution();
            int ans = ob.maxProfit(arr, k);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int maxProfit(int arr[], int k) {
        int n = arr.length;
        if (n == 0) return 0;

        int hold = -arr[0]; // If we buy stock on the first day
        int cash = 0;       // No profit initially

        for (int i = 1; i < n; i++) {
            // Update cash when selling stock
            cash = Math.max(cash, hold + arr[i] - k);
            // Update hold when buying stock
            hold = Math.max(hold, cash - arr[i]);
        }

        return cash;
    }
}
