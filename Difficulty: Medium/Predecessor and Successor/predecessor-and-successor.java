/*
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int k) {
        ArrayList<Node> res = new ArrayList<Node>();
        res.add(null); 
        res.add(null); 
        Node node = root;
        while(node != null) {
            if(node.data < k) {
                res.set(0, node); 
                node = node.right;
            } 
            else if(node.data > k) {
                res.set(1, node); 
                node = node.left;
            }
            else {
                Node temp = node.left;
                while(temp != null && temp.right != null) {
                    temp = temp.right;
                }
                if(temp != null) res.set(0, temp);
                temp = node.right;
                while(temp != null && temp.left != null) {
                    temp = temp.left;
                }
                if(temp != null) res.set(1, temp);
                break;
            }
        }
        return res;
    }
}