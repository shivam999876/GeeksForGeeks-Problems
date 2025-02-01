//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(ArrayList<String> a) {
        for (String e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }

            Solution obj = new Solution();
            ArrayList<String> v = obj.possibleWords(a);
            Collections.sort(v); // Sorting the ArrayList lexicographically
            IntArray.print(v);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // This function returns all possible words from the given phone digits.
    public ArrayList<String> possibleWords(int[] arr) {
        // Mapping of digits to corresponding characters.
        // Note: The mapping starts from digit 2 to 9.
        String[] mapping = {
            "abc",  // for digit 2
            "def",  // for digit 3
            "ghi",  // for digit 4
            "jkl",  // for digit 5
            "mno",  // for digit 6
            "pqrs", // for digit 7
            "tuv",  // for digit 8
            "wxyz"  // for digit 9
        };
        
        // This list will store all the possible words.
        ArrayList<String> result = new ArrayList<>();
        
        // Start the backtracking process from index 0 with an empty current string.
        backtrack(arr, mapping, 0, "", result);
        
        return result;
    }
    
    // The backtracking helper function.
    // 'index' is the current position in the arr array.
    // 'current' is the current combination of characters we have formed.
    // 'result' stores all the complete combinations.
    private void backtrack(int[] arr, String[] mapping, int index, String current, ArrayList<String> result) {
        // Base case: if the current string length equals the input array length,
        // then we have a complete word.
        if (index == arr.length) {
            result.add(current);
            return;
        }
        
        // Get the digit at the current index.
        int digit = arr[index];
        // Get the corresponding characters from the mapping array.
        // Note: Since our mapping array starts at digit 2, we use digit - 2 as index.
        String possibleChars = mapping[digit - 2];
        
        // Loop through all characters that the current digit can represent.
        for (int i = 0; i < possibleChars.length(); i++) {
            // Append the current character to the 'current' string and proceed to the next digit.
            backtrack(arr, mapping, index + 1, current + possibleChars.charAt(i), result);
        }
    }
}