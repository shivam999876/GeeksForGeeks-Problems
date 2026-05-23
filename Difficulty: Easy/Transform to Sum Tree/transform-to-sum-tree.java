/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {
    
    public int solve(Node root){
        if(root == null){
            return 0;
        }
        
        int leftSum = solve(root.left);
        int rightSum = solve(root.right);
        
        int temp = root.data;
        
        if(leftSum == 0 && rightSum == 0){
            root.data = 0;
            return temp;
        }else{
            root.data = leftSum + rightSum;
            return leftSum + rightSum + temp;
        }
    }
    public void toSumTree(Node root) {
        // code here
        solve(root);
    }
}