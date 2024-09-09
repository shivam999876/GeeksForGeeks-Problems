//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        // code here
        int n = arr.size(), zero = 0, two = n - 1, i = 0;
        while(i<=two){
            if(arr.get(i) == 0){
                int temp = arr.get(i);
                arr.set(i, arr.get(zero));
                arr.set(zero, temp);
                zero++;
            }
            else if(arr.get(i) == 2){
                int temp = arr.get(i);
                arr.set(i,arr.get(two));
                arr.set(two,temp);
                two--;
                i--;
            }
            i++;
        }
    }
}