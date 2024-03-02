//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class GfG { 
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    int[] arr = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++)arr[i] = Integer.parseInt(inputLine[i]);
		    
		    Solution obj = new Solution();
		    System.out.println(obj.firstElementKTime(n, k, arr));
		}
	}
}
// } Driver Code Ends
class Solution
{
    public int firstElementKTime(int n, int k, int[] a) { 
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:a){
            if(map.containsKey(i)){
                int s=map.get(i);
                map.put(i,s+1);
                s+=1;
                if(s>=k)return i;
            }else{
                map.put(i,1);
            }
        }
        return -1;
    } 
}
