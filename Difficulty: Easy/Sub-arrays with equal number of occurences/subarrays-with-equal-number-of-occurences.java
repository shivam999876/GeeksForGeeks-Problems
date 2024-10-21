//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java

class Solution {

   static int sameOccurrence(int arr[], int x, int y) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // To account for sub-arrays starting from index 0
        int countX = 0, countY = 0, result = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) countX++;
            if (arr[i] == y) countY++;
            
            // Calculate the difference between countX and countY
            int diff = countX - countY;
            
            // If this difference has been seen before, it means there are sub-arrays
            // with the same number of occurrences of x and y
            result += map.getOrDefault(diff, 0);
            
            // Update the frequency of the current diff in the map
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        
        return result;
    }
}

//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

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

            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.sameOccurrence(arr, x, y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends