

//User function Template for Java

/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        // code here
      ArrayList<Integer> res = new ArrayList<>();
      if(root == null) return res;
      Queue<Node> q = new LinkedList<>();
      q.offer(root);
      boolean lefttoright = true;
      while(!q.isEmpty()){
          Deque<Integer> level = new ArrayDeque<>();
          int size = q.size();
          for(int i=0;i<size;i++){
              Node curr = q.poll();
              if(lefttoright){
                  level.addLast(curr.data);
              }else{
                  level.addFirst(curr.data);
              }
              if(curr.left != null) q.offer(curr.left);
              if(curr.right != null) q.offer(curr.right);
          }
          res.addAll(level);
          lefttoright = ! lefttoright;
      }
     return res;

    }
}