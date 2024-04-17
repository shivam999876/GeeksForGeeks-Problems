//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();  
            System.out.println(obj.countPairs(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {  
    static int countPairs(int arr[], int n) 
    {
      for (int i = 0; i < n; i++) 
            arr[i] = i * arr[i]; 

           return countInversion(arr, 0,n-1);
    }
      static int countInversion( int arr[]  , int l , int r)
        {

        int res = 0;
            if(l<r)
            {
                int  m = (l+r)/2;
                // count inversion in left half
                res  +=  countInversion(arr,l,m);
                // count inversion in right half.
                res  +=  countInversion(arr,m+1,r);
                // count inversion while merging left and right parts.
                res +=  countAndMerge(arr,l,m,r);
            }
            return  res;
        }

        static int countAndMerge(int arr[] , int l , int m , int r)
        {
            int n1 = m-l+1;
            int n2 = r-m;
            int left[] = new int [n1];
            int right[] = new int [n2];

            for( int i = 0 ;i <n1; i++){
                left[i]  = arr[l+i];
            }
            for( int i = 0 ;i <n2; i++){
                right[i]  = arr[m+1+i];
            }
         int ans = 0, i=0 , j=0, k=l;

            while(i<n1 && j<n2){
                if(left[i]<=right[j]){
                    arr[k] = left[i] ; i++;k++;
                }

                else{
                    arr[k] = right[j]; j++ ;k++ ; ans += (n1-i);
                }
            }

            while(i<n1){
                arr[k] =  left[i]; i++;k++;
            }
            while(i<n2){
                arr[k] =right[j]; j++ ;k++;
            }
            return ans;
        }
}
