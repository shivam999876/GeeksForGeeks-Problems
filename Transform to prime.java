//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }
            Solution ob = new Solution();
            int ans=ob.minNumber(a,n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minNumber(int arr[], int N)
    {
        int res=0;
        int temp=0;
        
        for(int i=0;i<arr.length;i++){
            temp=temp+arr[i];
            
        }
        if(temp==1){
            return 1;
        }
        if(isPrimeNumber(temp)){
            return res;
        }else{
            int count=1;
            temp=temp+1;
            while(!isPrimeNumber(temp)){
                count++;
                temp++;
            }
            return count;
        }

    }
    public boolean isPrimeNumber(int n){
        boolean flag=true;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
               flag=false;
               break;
            }
        }
        return flag;
    }
}
