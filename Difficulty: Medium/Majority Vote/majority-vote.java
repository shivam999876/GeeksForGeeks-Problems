//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
     public List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        int n=nums.size(), can1=Integer.MIN_VALUE, can2=Integer.MIN_VALUE, counter1 = 0, counter2 = 0;
        for(int i=0;i<n;i++){
            if(nums.get(i)==can1)counter1++;
            else if(nums.get(i)==can2)counter2++;
            else if(counter1==0){
                can1=nums.get(i);
                counter1=1;
            }
            else if(counter2==0){
                can2=nums.get(i);
                counter2=1;
            }
            else{
                counter1--;
                counter2--;
            }
        }
        int vote1=0,vote2=0;
        for(int x:nums){
            if(x==can1)vote1++;
            if(x==can2)vote2++;
        }
        List<Integer> ans = new ArrayList<>();
        if(vote1>n/3)ans.add(can1);
        if(vote2>n/3)ans.add(can2);
        if(ans.isEmpty())ans.add(-1);
        return ans;
    }
}
