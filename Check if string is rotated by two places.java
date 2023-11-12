//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}
// } Driver Code Ends




class Solution
{
    //Function to check if a string can be obtained by rotating
    //another string by exactly 2 places.
public static boolean isRotated(String str1, String str2)
    {
        char[] chars = str1.toCharArray();
        rotateLeft(chars, 2);

        if (String.valueOf(chars).equals(str2))
            return true;

        chars = str1.toCharArray();
        rotateRight(chars, 2);

        if (String.valueOf(chars).equals(str2))
            return true;

        return false;
    }
    public static void rotateLeft(char[] chars, int d)
    {
        int n = chars.length;

        reverse(chars, 0, d - 1);
        reverse(chars, d, n - 1);
        reverse(chars, 0, n - 1);
    }
    public static void rotateRight(char[] chars, int d)
    {
        int n = chars.length;

        reverse(chars, 0, n - d - 1);
        reverse(chars, n - d, n - 1);
        reverse(chars, 0, n - 1);
    }
    public static void reverse(char[] chars, int start, int end)
    {
        while (start < end)
        {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
    }
}
