//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.util.Arrays;


// } Driver Code Ends

class Solution {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        Arrays.sort(start);
        Arrays.sort(end);
        int k=0,n=end.length;
        int ans=0;
        for(int i=0;i<end.length;i++){
            while(k<start.length&&start[k]<end[i]) k++;
            ans=Math.max(ans,k-i);
        }
        return ans;
    }
}


//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.minMeetingRooms(arr, brr);
            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends