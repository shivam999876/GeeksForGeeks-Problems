//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends
class Solution{
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) { 
        
        // Your code here
        int right[] = new int[n];
        right[n - 1] = a[n - 1];
        for(int i = n - 2; i >= 0; i--)right[i] = Math.max(a[i],right[i+1]);
        int i = 0, j = 0, ans = Integer.MIN_VALUE;
        while(i<n && j<n){
            if(a[i] <= right[j]){
                ans = Math.max(ans,j-i);
                j++;
            }
            else i++;
        }
        return ans;
    }
}
