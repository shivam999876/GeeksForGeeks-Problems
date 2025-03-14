//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {

   public int minCoins(int coins[], int sum) {
    // Filter out invalid coins (e.g., 0) to avoid issues
    coins = Arrays.stream(coins).filter(coin -> coin > 0).toArray();
    int n = coins.length;


    // DP table for storing results
    int[][] t = new int[n + 1][sum + 1];

    // Initialize the first row (if no coins are available, it's impossible to form any sum > 0)
    for (int j = 1; j <= sum; j++) {
        t[0][j] = Integer.MAX_VALUE - 1; // Set to a high value to indicate impossibility
    }

    // Initialize the first column (sum = 0 requires 0 coins)
    for (int i = 0; i <= n; i++) {
        t[i][0] = 0; // 0 coins are required to form a sum of 0
    }

    // Fill the DP table
    for (int i = 1; i <= n; i++) { // Start from the first coin type
        for (int j = 1; j <= sum; j++) {
            if (coins[i - 1] <= j) { // Coin can be included
                t[i][j] = Math.min(t[i - 1][j], 1 + t[i][j - coins[i - 1]]);
            } else { // Coin cannot be included
                t[i][j] = t[i - 1][j];
            }
        }
    }

    // Final result is in t[n][sum]
    return t[n][sum] == Integer.MAX_VALUE - 1 ? -1 : t[n][sum];
}


}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
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
            Solution obj = new Solution();
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends