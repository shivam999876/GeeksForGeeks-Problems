//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        int[] temp=new int[arr.length];
        return mergeSortAndcount(arr,temp,0,arr.length-1);
    }
    private static int mergeSortAndcount(int[] arr,int[] temp,int left,int right){
        int mid,invcount=0;
        if(left<right){
            mid=(left+right)/2;
            invcount+=mergeSortAndcount(arr,temp,left,mid);
            invcount+=mergeSortAndcount(arr,temp,mid+1,right);
            invcount+=mergeAndcount(arr,temp,left,mid+1,right);
        }
        return invcount;
    }
    private static int mergeAndcount(int[] arr,int[] temp,int left,int mid,int right){
        int i=left;
        int j=mid;
        int k=left;
        int invcount=0;
        while(i<=mid-1 && j<=right){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
                invcount+=(mid-i);
            }
        }
        while(i<=mid-1){
            temp[k++]=arr[i++];
        }
        while(j<=right){
            temp[k++]=arr[j++];
        }
        for(int x=left;x<=right;x++){
            arr[x]=temp[x];
        }
        return invcount;
    }
}