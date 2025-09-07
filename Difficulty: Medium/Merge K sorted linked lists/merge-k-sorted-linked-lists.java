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
    Node mergeKLists(Node[] arr) {
        // code here
        if(arr.length == 0) return null;
        
        return divide(0, arr.length-1, arr);
    }
    
    private Node divide(int start, int end, Node[] arr){
        if(start == end) return arr[start];
        int mid = start + (end-start)/2;
        
        Node head1 = divide(start, mid, arr);
        Node head2 = divide(mid+1, end, arr);
        
        Node head = merge(head1, head2);
        return head;
    }
    
    private Node merge(Node head1, Node head2){
        Node dummy = new Node(0);
        Node curr = dummy;
        
        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
                curr.next = head1;
                head1 = head1.next;
            }
            else{
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        
        if(head1 != null) curr.next = head1;
        else curr.next = head2;
        
        return dummy.next;
    }
}