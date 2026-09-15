/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    void collect(Node node, int depth, ArrayList<Integer> leaves) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            leaves.add(depth);
            return;
        }
        collect(node.left, depth + 1, leaves);
        collect(node.right, depth + 1, leaves);
    }
    public int getCount(Node root, int k) {
        ArrayList<Integer> leaves = new ArrayList<>();
        collect(root, 1, leaves);
        Collections.sort(leaves);
        int count = 0;
        for (int cost : leaves) {
            if (cost > k) break;
            k -= cost;
            count++;
        }
        return count;
    }
}