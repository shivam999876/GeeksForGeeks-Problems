

// User function Template for Java

/*class Node
{
    int key;
    Node left, right;

    Node(int x)
    {
        key = x;
        left = right = null;
    }

}*/
class Solution {
    int ans = -1;
    void inOrder(Node root,int k) {
        if(root == null) return;
        
        inOrder(root.left,k);
        if(root.data <= k) {
            ans = Math.max(ans,root.data);
            inOrder(root.right,k);
        }
    }
    public int findMaxFork(Node root, int k) {
        inOrder(root,k);
        return ans;
    }
}