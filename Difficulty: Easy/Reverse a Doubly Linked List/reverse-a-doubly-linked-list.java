/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
         Node p = head;
    Node temp = null;
    while(p!=null){
        
        temp = p.next;
        
        //just swap the pointer
        Node left = p.prev;
        p.prev = p.next;
        p.next = left;
        if(temp == null){
            break;
        }
        p = temp;
    }
    return p;
    }
}