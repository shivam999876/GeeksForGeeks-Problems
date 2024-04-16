//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minimizeDifference(n, k, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int minimizeDifference(int n, int k, int[] arr) {
        // code here
         int[] maxSuff=new int[n+1];
        int[] minSuff=new int[n+1];
        maxSuff[n]=Integer.MIN_VALUE; 
        minSuff[n]=Integer.MAX_VALUE; 
        maxSuff[n-1]=arr[n-1];
        minSuff[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            maxSuff[i]=Math.max(maxSuff[i+1],arr[i]);
            minSuff[i]=Math.min(minSuff[i+1],arr[i]);
        }
        int mindiff=maxSuff[k]-minSuff[k]; //aditya
        int minPre=arr[0];
        int maxPre=arr[0];
        for(int i=1;i<n;i++){
            if(i+k<=n){
            int maxi=Math.max(maxSuff[i+k],maxPre);
            int mini=Math.min(minSuff[i+k],minPre);
            mindiff=Math.min(mindiff,maxi-mini);
            }
            minPre=Math.min(minPre,arr[i]);
            maxPre=Math.max(maxPre,arr[i]);
        }
        return mindiff;
    }
}
