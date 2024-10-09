//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;


// } Driver Code Ends

class Solution {
    public int maxDistance(int[] arr) {
        // Initialize a HashMap to store the latest index of each element.
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate through the array to populate the map.
        for (int i = 0; i < arr.length; i++) {
            // If the element is already in the map and its stored index is less than the current index,
            // update the index with the current index.
            if (map.containsKey(arr[i]) && map.get(arr[i]) < i) {
                map.put(arr[i], i);
            }
            // If the element is not in the map, add it with the current index.
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            }
        }

        // Initialize the maximum distance to -1.
        int max = -1;

        // Iterate through the array again to find the maximum distance.
        for (int i = 0; i < arr.length; i++) {
            // Calculate the distance from the current index to the latest index of the element.
            if (map.get(arr[i]) - i > max) {
                max = map.get(arr[i]) - i;
            }
        }

        // Return the maximum distance found.
        return max;
    }
}



//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String input = sc.nextLine();
            String[] parts = input.split(" ");
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxDistance(arr));
        }
        sc.close();
    }
}
// } Driver Code Ends