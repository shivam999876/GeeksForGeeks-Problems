//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                String str = br.readLine();
                Solution ob = new Solution();
                String str1 = ob.rearrangeString(str);

                int flag = 1;
                int[] c = new int[26];
                Arrays.fill(c, 0);
                for (int i = 0; i < str.length(); i++) c[str.charAt(i) - 'a'] += 1;
                int f = 0;
                int x = (str.length() + 1) / 2;
                for (int i = 0; i < 26; i++) {
                    if (c[i] > x) f = 1;
                }
                if (f == 1) {
                    if (str1 == "")
                        System.out.println(0);
                    else
                        System.out.println(1);
                } else {
                    int[] a = new int[26];
                    Arrays.fill(a, 0);
                    int[] b = new int[26];
                    Arrays.fill(b, 0);
                    for (int i = 0; i < str.length(); i++) a[str.charAt(i) - 'a'] += 1;
                    for (int i = 0; i < str1.length(); i++)
                        b[str1.charAt(i) - 'a'] += 1;

                    for (int i = 0; i < 26; i++)
                        if (a[i] != b[i]) flag = 0;

                    for (int i = 0; i < str1.length(); i++) {
                        if (i > 0)
                            if (str1.charAt(i - 1) == str1.charAt(i)) flag = 0;
                    }
                    if (flag == 1)
                        System.out.println(1);
                    else
                        System.out.println(0);
                }

                System.out.println("~");
            }
        } catch (Exception e) {
        }
    }
}
// } Driver Code Ends


class Solution {
   static String rearrangeString(String s) {
        int n = s.length();
        
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(freq.entrySet());
        
        StringBuilder res = new StringBuilder();
        
        Map.Entry<Character, Integer> prev = new AbstractMap.SimpleEntry<>('#', -1);
        
        while (!pq.isEmpty()) {
   
            Map.Entry<Character, Integer> p = pq.poll();
            res.append(p.getKey());
            
            if (prev.getValue() > 0)
                pq.offer(prev);
            
            prev = new AbstractMap.SimpleEntry<>(p.getKey(), p.getValue() - 1);
        }
        
        if (res.length() != n)
            return "";
        
        return res.toString();
    }
}