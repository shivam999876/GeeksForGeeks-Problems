//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public int findSubString(String str) {
        Set<Character> st=new HashSet<>();
        for(char i:str.toCharArray())
        st.add(i);
        int cnt=Integer.MAX_VALUE;
        int r=0,l=0;
        Map<Character,Integer> map=new LinkedHashMap<>();
        while(r<str.length())
        {
            map.put(str.charAt(r),map.getOrDefault(str.charAt(r),0)+1);
            if(map.size()==st.size())
            {
                while(map.size()==st.size())
                {
                    cnt=Math.min(cnt,r-l+1);
                    map.put(str.charAt(l),map.get(str.charAt(l))-1);
                    if(map.get(str.charAt(l))==0)
                    map.remove(str.charAt(l));
                    l++;
                }
            }
            r++;
        }
        return cnt;
    }
}