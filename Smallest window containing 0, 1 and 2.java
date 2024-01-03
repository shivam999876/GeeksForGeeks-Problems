//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        HashMap<Character, Integer> map = new HashMap<>();
        int n = S.length();
        
        int ans = Integer.MAX_VALUE;
        int st=0;
        for(int i=0; i<n; i++){
            char ch = S.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
            if(map.size()==3){
                
                while(st<i && map.get(S.charAt(st))>1){
                    map.put(S.charAt(st), map.getOrDefault(S.charAt(st),0)-1);
                    st++;
                }
                ans = Math.min(ans, i-st+1);
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
};
