//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution {
  String reverseWords(String S)
    {
    char[] str = S.toCharArray();
        int n = str.length;
        
      //reverse each word in string
        int start = 0;
        for (int end = 0; end < n; end++) {
            if (str[end] == '.') {
                reverse(str, start, end - 1);
                start = end + 1; 
            }
        }
      //rev last word
        reverse(str, start, n - 1);
        
        //Reverse the entire string
        reverse(str, 0, n - 1);
        
        return new String(str);
    }
    
    void reverse(char[] str, int low, int high)
    {
        while (low < high) {
            char temp = str[low]; str[low] = str[high]; str[high] = temp;
            low++; high--;
        }
    }
}