//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
        public static int minChar(String s) {
        // Write your code here
        StringBuilder rev = new StringBuilder();
        rev.append(s);
        rev.reverse();
        StringBuilder com = new StringBuilder();
        com.append(s).append('$').append(rev.toString());
        String complete = com.toString();
        int n = complete.length(),i = 0, j = 1;
        int lps[] = new int[n];
        Arrays.fill(lps,0);
        while(j<n){
            if(complete.charAt(j) == complete.charAt(i))lps[j++] = ++i;
            else if(i!=0)i=lps[i-1];
            else j++;
        }
        return s.length()-i;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        var sc = new FastReader();
        int test = sc.nextInt();
        while (test-- > 0) {
            String s = sc.nextString();
            System.out.println(Solution.minChar(s));

            System.out.println("~");
        }
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer("");
        }

        private void read() throws IOException {
            st = new StringTokenizer(br.readLine());
        }

        public String nextString() throws IOException {
            while (!st.hasMoreTokens()) read();
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(nextString());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(nextString());
        }
    }
}
// } Driver Code Ends