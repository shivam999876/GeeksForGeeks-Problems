//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            ArrayList<String> result = obj.findPath(mat);

            if (result.isEmpty()) {
                System.out.println("[]");
            } else {
                for (String res : result) {
                    System.out.print(res + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        
        ArrayList<String> list = new ArrayList<>();
        boolean [][]visited = new boolean [mat.size()][mat.size()];
        helper(0, 0, mat, list, visited, "");
        return list;
        
    }
    
    private void helper(int row, int col, ArrayList<ArrayList<Integer>> board, ArrayList<String> list, boolean [][]visited, String psf){
        
        if(row < 0 || row == board.size() || col < 0 || col == board.size() || board.get(row).get(col) == 0 || visited[row][col]){
            return;
        }
        
        if(row == board.size() - 1 && col == board.size() - 1){
            list.add(psf);
        }
        
        visited[row][col] = true;
        
        // down
        helper(row + 1, col, board, list, visited, psf + "D");
        
        // left
        helper(row, col - 1, board, list, visited, psf + "L");
        
        // right
        helper(row, col + 1, board, list, visited, psf + "R");
        
        // up
        helper(row - 1, col, board, list, visited, psf + "U");
        
        visited[row][col] = false;
        
    }
    
}

