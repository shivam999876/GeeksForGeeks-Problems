//{ Driver Code Starts
import java.util.*;

class GenIP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution sln = new Solution();
            ArrayList<String> str = sln.generateIp(s);
            Collections.sort(str);
            if (str.size() == 0)
                System.out.println(-1);
            else {
                for (String u : str) {
                    System.out.println(u);
                }
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*complete the Function*/

class Solution {
    // Function to check whether a segment is valid
    private boolean isValid(String s) {
        int n = s.length();

        // Single-digit numbers are always valid
        if (n == 1) return true;

        // Convert to integer
        int val = Integer.parseInt(s);

        // Invalid case: Leading zero or value greater than 255
        return s.charAt(0) != '0' && val <= 255;
    }

    // Recursive function to generate valid IP addresses
    private void generateIpRec(String s, int index, String curr, int cnt, ArrayList<String> res) {
        String temp = "";

        // Base case: If we reach the end of the string
        if (index >= s.length()) return;

        // If we have already added 3 dots, check the remaining part
        if (cnt == 3) {
            temp = s.substring(index);
            if (temp.length() <= 3 && isValid(temp)) {
                res.add(curr + temp);
            }
            return;
        }

        // Iterate through the next possible segments (1 to 3 digits)
        for (int i = index; i < Math.min(index + 3, s.length()); i++) {
            temp += s.charAt(i);

            // If the segment is valid, continue generating the IP
            if (isValid(temp)) {
                generateIpRec(s, i + 1, curr + temp + ".", cnt + 1, res);
            }
        }
    }

    // Function to generate valid IP addresses
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> res = new ArrayList<>();
        
        // IP addresses must be between 4 and 12 characters long
        if (s.length() < 4 || s.length() > 12) return res;

        generateIpRec(s, 0, "", 0, res);
        return res;
    }
}


