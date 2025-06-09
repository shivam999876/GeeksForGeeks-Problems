/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    public boolean isDeadEnd(Node root) {
        // Code here.
          HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> leaf = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            visited.add(node.data);
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
            if(node.left ==  null  && node.right == null){
                leaf.add(node.data);
            }
        }
        
        for (Integer ele : leaf) { 
            // Print HashSet data 
           if((ele == 1 && visited.contains(2)) ||
                visited.contains(ele-1) && visited.contains(ele+1)){
                return true;
            }
        } 
        return false;
    }
}