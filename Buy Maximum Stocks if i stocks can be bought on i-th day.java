//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Pair implements Comparable<Pair>
{ 
    int cost, quan;

    Pair(int cost, int quan)
    {
        this.cost = cost;
        this.quan = quan;
    }

    public int compareTo(Pair a)  
    { return this.cost - a.cost; }
};
class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        ArrayList<Pair> arr = new ArrayList<>();

        for( int i =0; i<n; i++)
            arr.add(new Pair(price[i], i+1));

       Collections.sort(arr);

        int ans=0;
        for(int i =0; i<n ; i++){
             int units = Math.min(arr.get(i).quan, k / arr.get(i).cost);
            ans += units;
            k -= arr.get(i).cost * units;
        }
        return ans;
    }
}
