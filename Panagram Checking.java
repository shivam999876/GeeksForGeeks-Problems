**Method 1:**
//{ Driver Code Starts
//Initial template for JAVA

import java.lang.*;
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
        // your code here
        if(s.length()<26)return false;
        Map<Integer,Integer> mm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char x = s.charAt(i);
            if(x >= 'A' && x <= 'Z'){
                mm.putIfAbsent(x - 'A',1);
            }
            else if(x >= 'a' && x <= 'z'){
                mm.putIfAbsent(x - 'a',1);
            }
        }
        return mm.size() >= 26;
    }
}

//{ Driver Code Starts.

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends




**Method 2:**
//{ Driver Code Starts
//Initial template for JAVA
import java.lang.*;
import java.io.*;
import java.util.*;
// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
        // your code here
        HashSet<Character> set = new HashSet<>();
        for(char ch : s.toCharArray())
        {
            if(ch >= 'a' && ch <= 'z')
            set.add(ch);
            
            if(ch >= 'A' && ch <= 'Z')
            set.add(Character.toLowerCase(ch));
        }
        return set.size()==26;
    }
}


//{ Driver Code Starts.

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends
