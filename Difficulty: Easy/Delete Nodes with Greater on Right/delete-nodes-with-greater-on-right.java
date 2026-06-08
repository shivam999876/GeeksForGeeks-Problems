/* Structure of linked list node
class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    Node compute(Node head) {
        // code here
        Node cur = head;
        Node prev = null;
        Node next;
        while(cur!=null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
        Node current = head;
        Node maxNode = head;
        Node temp;
         while (current != null && current.next != null)
         {
             if(current.next.data < maxNode.data)
             {
                 temp = current.next;
                 current.next = temp.next;
             }
             else
             {
                 current = current.next;
                 maxNode= current;
             }
         }
         cur = head;
         prev = null;
         while(cur!=null)
         {
             next = cur.next;
             cur.next = prev;
             prev = cur;
             cur = next;
         }
         head = prev;
        return head;
    }
}