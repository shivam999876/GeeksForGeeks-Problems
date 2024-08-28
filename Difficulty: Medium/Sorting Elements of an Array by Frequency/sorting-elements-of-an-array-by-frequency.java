//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
       public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        int n = arr.length;
        HashMap<Integer,Integer> mm = new HashMap<>();
        int vec[][] = new int[n][2];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int x:arr)mm.put(x,mm.getOrDefault(x,0)+1);
        for(int i=0;i<n;i++){
            vec[i][0]=arr[i];
            vec[i][1]=mm.get(arr[i]);
        }
        Arrays.sort(vec,new Comparator<int[]>(){
            @Override
            public int compare(int a[],int b[]){
                if(a[1]!=b[1])return b[1]-a[1];
                return a[0]-b[0];
            }
        });
        for(int i=0;i<n;i++)ans.add(vec[i][0]);
        return ans;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends