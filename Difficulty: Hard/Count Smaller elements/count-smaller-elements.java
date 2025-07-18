//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int arr[] = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }

            int[] ans = new Solution().constructLowerArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
       int binarySearch(ArrayList<Integer> temp,int element){
        int index=-1;
        int low=0,high=temp.size()-1,mid;
        while(low<=high){
            mid=(low+high)/2;
            if(temp.get(mid)==element){
                index=mid;
                high=mid-1;
            }
            else if(temp.get(mid)>element) high=mid-1;
            else low=mid+1;
        }
        return index;
    }
    int[] constructLowerArray(int[] arr) {
        // code here
        int ans[] = new int[arr.length];
	    ArrayList<Integer> temp = new ArrayList<>();
	    for(int i=0;i<arr.length;i++)temp.add(arr[i]);
	    Collections.sort(temp);
	    for(int i=0;i<arr.length;i++){
	        int index = binarySearch(temp,arr[i]);
	        ans[i]=index;
	        temp.remove(index);
	    }
	    return ans;
    }
}