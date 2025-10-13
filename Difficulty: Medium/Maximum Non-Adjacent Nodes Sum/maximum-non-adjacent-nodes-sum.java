/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    HashMap<Node, Integer> dp = new HashMap<>();
    public int getMaxSum(Node root) {
        // code here
        return dfs(root);
    }
    int dfs(Node root){
        if(root == null)
            return 0;
            if(dp.containsKey(root))
            return dp.get(root);
            int dt = dfs(root.left) + dfs(root.right);
            int take = root.data;
            if(root.left != null){
                take += dfs(root.left.left) + dfs(root.left.right);
            }
            if(root.right != null){
                take += dfs(root.right.left) + dfs(root.right.right);
            }
            int result = Math.max(dt, take);
            dp.put(root, result);
            return result;
        }
}