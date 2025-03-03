//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().split(" ");
            int arr[] = new int[input.length];

            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(input[i]);

            // Read the integer k
            int k = Integer.parseInt(br.readLine());

            // Call the solution function
            Solution obj = new Solution();
            System.out.println(obj.getScore(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int getScore(int arr[], int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        dp[0] = arr[0];
        deque.offer(0);
        
        for (int i = 1; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            dp[i] = arr[i] + dp[deque.peekFirst()];
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.offer(i);
        }
        return dp[n - 1];
    }
}