/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
          Node slow=head, fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)break;
        }
        if(fast==null || fast.next==null)return 0;
        int ans=0;
        Node temp=slow.next;
        while(temp!=slow){
            temp=temp.next;
            ans++;
        }
        return ans+1;
    }
}