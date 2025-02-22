//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    
    static class Compare implements Comparator<int[]> {
        public int compare(int[] p1, int[] p2) {
            
            if (p1[1] == p2[1])
                return Integer.compare(p2[0], p1[0]);
            return Integer.compare(p2[1], p1[1]);
        }
    }
    public ArrayList<Integer> topKFrequent(int[] arr, int k) {
       int n = arr.length;
        
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++)
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);

        ArrayList<int[]> freq = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mp.entrySet())
            freq.add(new int[]{entry.getKey(), entry.getValue()});

        
        freq.sort(new Compare());
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(freq.get(i)[0]);
        }

        return res;
    }
}




//{ Driver Code Starts.

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
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
            ArrayList<Integer> res = new Solution().topKFrequent(arr, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends