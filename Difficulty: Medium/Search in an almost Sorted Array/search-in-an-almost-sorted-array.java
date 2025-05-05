//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

// User function Template for Java
class Solution {
    public int findTarget(int arr[], int target) {
        // code here
        int n=arr.length,start=0,end=(n-1)/2;
        if(n==1)return target==arr[0]?0:-1;
        while(start<end) {
            int mid=(start+end)>>1;
            if(arr[2*mid]==target)return 2*mid;
            else if(arr[2*mid]>target) end=mid-1;
            else start=mid+1;
        }
        if(arr[2*start]==target)return 2*start;
        start=0;
        end=(n-1)/2;
        while(start<end) {
            int mid=(start+end)>>1;
            if(arr[2*mid+1]==target)return 2*mid+1;
            else if(arr[2*mid+1]>target)end=mid-1;
            else start=mid+1;
        }
        return (2*start+1>=n)?-1:(arr[2*start+1]==target?(2*start+1):-1);
        
    }
}



//{ Driver Code Starts.

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String temp[] = sc.nextLine().trim().split(" ");
            int n = temp.length;
            int arr[] = new int[n];
            int target = sc.nextInt();
            if (sc.hasNextLine()) sc.nextLine();
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(temp[i]);
            Solution sln = new Solution();
            int ans = sln.findTarget(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends