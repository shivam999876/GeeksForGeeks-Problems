//{ Driver Code Starts
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
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
         HashMap<String, Integer> map = new HashMap<>();

        for (String a : arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        int max = 0;
        String b = "";
        for (String a : arr) {
            if (map.get(a) > max) {
                max = map.get(a);
                b = a;
            }
        }
        int max2 = 0;
        String c = "";
        for (String a : arr) {
            if (b.equals(a)) {
                continue;
            } else if (map.get(a) == max) {
                    b = lexicoString(b,a);
            }
        }

        return new String[]{b, Integer.toString(max)};
    }

    public static String lexicoString(String str1, String str2) {
    int minLength = Math.min(str1.length(), str2.length());
    for (int i = 0; i < minLength; i++) {
        char char1 = str1.charAt(i);
        char char2 = str2.charAt(i);
        if (char1 == char2) {
            continue;
        } else if (char1 < char2) {
            return str1;
        } else {
            return str2;
        }
    }
    return str1.length() < str2.length() ? str1 : str2;
    }
}
