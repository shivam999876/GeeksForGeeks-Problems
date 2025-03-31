//{ Driver Code Starts
// Initial Template for Java
import java.util.*;


// } Driver Code Ends

class Solution {
    
    public int catchThieves(char[] arr, int k) {

        // For each police, try to catch the leftmost thief
        // So that police on the right also has thieves to catch.
        
        int thievesCaught = 0;
        
        Queue<Integer> thieves = new LinkedList<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'T') {
                thieves.add(i);
            }
        }
        
        for (int i = 0; i < arr.length && !thieves.isEmpty(); i++) {
            if (arr[i] == 'P') {
                
                while (!thieves.isEmpty()) {
                    Integer thiefPosition = thieves.peek();
                    
                    if (thiefPosition > i + k) {
                        break;
                    }
                    
                    if (thiefPosition < i - k) {
                        thieves.remove();
                        continue;
                    }
                    
                    // thief can be caught
                    thieves.remove();
                    thievesCaught++;
                    break;
                }
                
            }
        }
        
        return thievesCaught;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine().trim());

        while (t-- > 0) {
            String[] input = sc.nextLine().trim().split(" ");
            char[] arr = new char[input.length];

            for (int i = 0; i < input.length; i++) {
                arr[i] = input[i].charAt(0);
            }

            int k = Integer.parseInt(sc.nextLine().trim());

            Solution ob = new Solution();
            System.out.println(ob.catchThieves(arr, k));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends