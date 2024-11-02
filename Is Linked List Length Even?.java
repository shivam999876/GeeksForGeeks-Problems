class Solution {
    public boolean isLengthEven(Node head) {
        // code here
        
        int length=0;
        
        
        while(head !=null){
            
             length++;
            head=head.next;
        }
        return  length % 2 ==0;
    }
}
