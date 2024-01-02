//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long maxSumWithK(long a[], long n, long k)
    {
         long maxSum[] = new long[(int)n];
        int curr=0;

        int max=Integer.MIN_VALUE;
        for(int i=0; i<n;i++){    
            curr+=a[i];
            max=Math.max((int)a[i],curr);
            maxSum[i] = max;

            if(curr<0)
                curr=0;
        }
       
        long sum=0;
         for(int i=0; i<k; i++){    
             sum+=a[i];
         }
         long ans=sum;
           for(int i=(int)k; i<n; i++){ 
               sum+= a[i] - a[i-(int)k];

               ans=Math.max(ans, (int)sum); //handling exaclty k

                ans=Math.max(ans, (int)sum + maxSum[i-(int)k]); // for more than k
           }

        return ans;
    }
}
