//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.uniqueCombinations(arr, sum);
            if (ans.size() == 0)
                System.out.println(-1);
            else {
                for (ArrayList<Integer> row : ans) {
                    Collections.sort(row);
                }
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() -
                        list2.size(); // If equal, smaller list comes first
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


// User function template for JAVA

class Solution {
    // Helper function to find all unique combinations
    private static void findCombinations(int[] arr, int index, int target, 
             ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> res) {

        // If a valid combination is found
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // If target becomes negative or we exhaust the array, backtrack
        if (target < 0 || index >= arr.length) 
            return;

        // Iterate through elements starting from index
        for (int i = index; i < arr.length; i++) {

            // Skip duplicate elements to ensure unique combinations
            if (i > index && arr[i] == arr[i - 1])
                continue;

            // Include current element
            curr.add(arr[i]);

            // Recur for the next elements with reduced target
            findCombinations(arr, i + 1, target - arr[i], curr, res);

            // Backtrack by removing the last element
            curr.remove(curr.size() - 1);
        }
    }

    // Function to find all unique combinations that sum to target
    public static ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {
        // Sort the array to handle duplicates and maintain order
        Arrays.sort(arr);

        // List to store results
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // Temporary list to store current combination
        ArrayList<Integer> curr = new ArrayList<>();

        // Call helper function
        findCombinations(arr, 0, target, curr, res);
        return res;
    }
}