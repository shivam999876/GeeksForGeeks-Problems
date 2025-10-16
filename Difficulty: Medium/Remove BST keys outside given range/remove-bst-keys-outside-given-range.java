/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    Node removekeys(Node root, int l, int r) {
        // code here
        return dfs(root, l, r);
    }
    Node dfs(Node root, int l, int r){
        if(root == null)
        return null;
        root.left = dfs(root.left, l, r);
        root.right = dfs(root.right, l, r);
        if(root.data < l){
            return root.right;
        }
        if(root.data > r){
            return root.left;
        }
        return root;
    }
}