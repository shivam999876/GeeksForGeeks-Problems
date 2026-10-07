/* Node Structure
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    private int maxSum;
    private int leafCount;
    public int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        leafCount = 0;
        solve(root);
        if (leafCount < 2) {
            return -1;
        }
        return maxSum;
    }
    private int solve(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            leafCount++;
            return node.data;
        }
        int leftSum = solve(node.left);
        int rightSum = solve(node.right);
        if (node.left != null && node.right != null) {
            maxSum = Math.max(maxSum, leftSum + rightSum + node.data);
            return node.data + Math.max(leftSum, rightSum);
        }
        return (node.left != null) ? node.data + leftSum : node.data + rightSum;
    }
}
