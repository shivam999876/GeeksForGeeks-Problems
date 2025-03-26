//{ Driver Code Starts
import java.util.Scanner;

class Distinct_Occurrences {
    public static void main(String[] args) {
        Scanner scanner =
            new Scanner(System.in); // Create a Scanner object to read input

        int t = Integer.parseInt(scanner.nextLine()); // Read the number of test cases
        while (t-- > 0) {
            String txt = scanner.nextLine(); // Read the first line as txt
            String pat = scanner.nextLine(); // Read the second line as pat
            System.out.println(new Solution().subseqCount(
                txt, pat)); // Call the method and print the result
            System.out.println("~");
        }

        scanner.close(); // Close the scanner
    }
}

// } Driver Code Ends



class Solution {
    public int subseqCount(String txt, String pat) {
        int[] arr = new int[txt.length()];
        for(int i = 0; i<txt.length();i++){
            if(txt.charAt(i) == pat.charAt(pat.length()-1)){
                arr[i] = 1;
            }
        }
        int count;
        int prev;
        for(int i=pat.length()-2;i>=0;i--){
            count = 0;
            for(int j=txt.length()-1; j>=0; j--){
                prev = arr[j];
                if(txt.charAt(j) == pat.charAt(i)){
                    arr[j] = count;
                }
                if(txt.charAt(j) == pat.charAt(i+1)){
                    count+= prev;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<txt.length();i++){
            if(txt.charAt(i) == pat.charAt(0)){
                ans+=arr[i];
            }
        }
        return ans;
    }
}