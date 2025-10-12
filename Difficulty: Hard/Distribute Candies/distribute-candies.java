/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    private int a = 0;
    public int distCandy(Node root) {
        // code here
        dfs(root);
        return a;
    }
    private int dfs(Node node){
        if(node == null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        a += Math.abs(left) + Math.abs(right);
        return node.data + left + right - 1;
    }
}