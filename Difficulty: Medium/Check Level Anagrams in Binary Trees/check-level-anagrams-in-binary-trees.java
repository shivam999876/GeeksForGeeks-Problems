/* Structure of binary tree Node
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
    public boolean areAnagrams(Node root1, Node root2) {

        if(root1==null && root2 == null)
        {
            return true;
        }

        if((root1==null && root2!=null) || (root1!=null && root2==null))
        {
            return false;
        }
        Queue<Node> q1= new LinkedList<>();
        Queue<Node> q2= new LinkedList<>();
        q1.offer(root1);
        q2.offer(root2);

        while(!q1.isEmpty() || !q2.isEmpty())
        {
            if(q1.size()!=q2.size())
            {
                return false;
            }
            int r=q1.size();

            ArrayList<Integer> l1=new ArrayList<>(),l2=new ArrayList<>();


            for(int i=0;i<r;i++)
            {
                Node node1=q1.poll();
                Node node2=q2.poll();
                l1.add(node1.data);
                l2.add(node2.data);

                if(node1.left!=null)
                {
                    q1.offer(node1.left);

                }
                if(node1.right!=null)
                {
                    q1.offer(node1.right);

                }
                if(node2.left!=null)
                {
                    q2.offer(node2.left);

                }
                if(node2.right!=null)
                {
                    q2.offer(node2.right);

                }

            }
            Collections.sort(l1);
            Collections.sort(l2);

            if(!l1.equals(l2))
            {
                return false;
            }


        }

        return true;



    }
}
