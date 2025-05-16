//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    static class Node {
        int val, row, col;
        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        int n = arr[0].length;

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        int max = Integer.MIN_VALUE;

        // Step 1: Add first element from each list
        for (int i = 0; i < k; i++) {
            minHeap.offer(new Node(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        int start = 0, end = Integer.MAX_VALUE;

        while (true) {
            Node minNode = minHeap.poll();
            int min = minNode.val;

            // Update result if smaller range found
            if (max - min < end - start) {
                start = min;
                end = max;
            }

            // If the current list is exhausted, break
            if (minNode.col + 1 == n) break;

            // Push next element from the same list
            int nextVal = arr[minNode.row][minNode.col + 1];
            max = Math.max(max, nextVal);
            minHeap.offer(new Node(nextVal, minNode.row, minNode.col + 1));
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(start);
        result.add(end);
        return result;
    }
}