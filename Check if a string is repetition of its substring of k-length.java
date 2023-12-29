//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String s = sc.next();
            int k = sc.nextInt();
            int answer = new Solution().kSubstrConcat(n,s,k);
    		System.out.println(answer);
        }
        
    }
}

// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Solution {
    static int kSubstrConcat(int n, String s, int k) {
        if (n % k != 0) {
            return 0;
        }

        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> uniqueSubstrings = new HashSet<>();

        for (int i = 0; i <= n - k; i += k) {
            String temp = s.substring(i, i + k);

            if (uniqueSubstrings.contains(temp)) {
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            } else {
                uniqueSubstrings.add(temp);
            }
        }

        if (uniqueSubstrings.size() > 2) {
            return 0;
        }

        return 1;
    }
}
