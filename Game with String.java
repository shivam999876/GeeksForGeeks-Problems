//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends
// User function Template for Java
class Solution{
    static int minValue(String s, int k){
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
        map.put(ch, map.getOrDefault(ch, 0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : map.values())
        pq.add(x);
        while(k>0){
        int curr = pq.poll();
        pq.add(curr - 1);
        k--;
    }
    int ans = 0;
    while(!pq.isEmpty()){
        int curr = pq.poll();
        ans += (curr*curr);
    }
    return ans;
}
}
