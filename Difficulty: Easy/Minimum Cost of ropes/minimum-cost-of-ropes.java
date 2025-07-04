//{ Driver Code Starts

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int[] a = new int[input.length];

            for (int i = 0; i < input.length; i++) {
                a[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.minCost(a));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends

class Solution {
    // Function to return the minimum cost of connecting the ropes.
    public int minCost(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        int cost=0;
        while(pq.size()>1){
            int min=pq.remove();
            int min2=pq.remove();
            cost+=min+min2;
            pq.add(min+min2);
        }
        return cost;
    }
}