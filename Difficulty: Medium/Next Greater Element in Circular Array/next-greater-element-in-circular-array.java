//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// } Driver Code Ends

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stk = new Stack<>();

        // Traverse the array from right to left
        for (int i = 2 * n - 1; i >= 0; i--) {

            // Pop elements from the stack that are less than or equal to the current element
            while (!stk.isEmpty() && stk.peek() <= arr[i % n]) {
                stk.pop();
            }

            // If the stack is not empty, the top element is the next greater element
            if (i < n && !stk.isEmpty()) {
                res.set(i, stk.peek());
            }

            // Push the current element onto the stack
            stk.push(arr[i % n]);
        }

        return res;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // Number of test cases
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int N = arr.length;
            Solution ob = new Solution();
            ArrayList<Integer> result =
                ob.nextLargerElement(arr); // Generate the next permutation
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < N; i++) {
                out.append(result.get(i))
                    .append(" "); // Corrected: Use result.get(i) instead of result[i]
            }

            System.out.println(out.toString().trim()); // Print the output
            System.out.println("~");
        }
    }
}

// } Driver Code Ends