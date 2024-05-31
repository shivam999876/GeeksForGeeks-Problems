//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends
class Solution{
    static String oddEven(String s) {
        int[] h=new int[26];
        for(int i=0;i<s.length();i++){
            h[s.charAt(i)-'a']++;
        }
        int sum=0;
        for(int i=0;i<26;i++){
            if(h[i]!=0 && ((i+h[i])&1)==1){sum++;}
        }
        return (sum&1)==1?"ODD":"EVEN";
    }
}
