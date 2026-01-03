/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    private int getNext(ArrayList<Node> heads){
        int min_data = 100000, j = -1;
        for(int i = 0; i < heads.size(); i++){
            Node head = heads.get(i);
            if(head != null && head.data < min_data){
                j = i;
                min_data = head.data;
            }
        }
        return j;
    }
    public Node flatten(Node root) {
        // code here
        Node curr = new Node(-1);
        Node ans = curr;
        ArrayList<Node> heads = new ArrayList<>();
        while(root != null){
            heads.add(root);
            root = root.next;
        }
        while(true){
            int j = getNext(heads);
            if(j == -1) break;
            Node target = heads.get(j);
            curr.bottom = target;
            curr = curr.bottom;
            heads.set(j, target.bottom);
        }
        return ans.bottom;
    }
}