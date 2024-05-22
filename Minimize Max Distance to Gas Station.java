//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
   static boolean isPossible(int stations[],double mid,int k){
        int total=0;
        for(int i=1;i<stations.length;i++){
            int dis = stations[i]-stations[i-1];
            total+=Math.ceil(dis/mid)-1;
        }
        return total<=k;
    }
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int n = stations.length;
        double low=0,high=stations[n-1]-stations[0],mid=0,ans=0;
        ans=high;
        while(high-low>=1e-6){
            mid=(low+high)/2.0;
            if(isPossible(stations,mid,k)){
                ans=mid;
                high=mid;
            }
            else low=mid;
        }
        return ans;
    }
}
