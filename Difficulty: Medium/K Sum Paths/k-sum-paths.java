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
        public int res = 0;
        public int countAllPaths(Node root, int k){
            // code here
            count(root, k);
            return res;
        }
        public void count(Node curr, int k){
            if(curr == null){
                return;
            }
            helper(curr, k, 0);
            count(curr.left, k);
            count(curr.right, k);
        }
        public void helper(Node curr, int k, int currSum){
            if(curr == null){
                return;
            }
            currSum += curr.data;
            if(currSum == k){
                res++;
            }
            helper(curr.left, k, currSum);
            helper(curr.right, k, currSum);
    }
}