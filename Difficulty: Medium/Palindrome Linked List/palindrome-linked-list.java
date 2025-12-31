



/* Structure of class Node is
class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    // Function to check whether the list is palindrome.
    static boolean isPalindrome(Node head) {
        if(head==null || head.next==null) return true;
        
        Stack<Node> st = new Stack<>();
        Node temp = new Node(-1);
        temp.next = head;
        Node slow = temp;
        Node fast = temp;
        
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            st.push(slow);
        }
        
        temp = slow.next;
        
        if(fast==null) st.pop();
        
        while(!st.isEmpty()) {
            if(temp.data != st.pop().data) return false;
            temp = temp.next;
        }
        
        return true;
    }
}
