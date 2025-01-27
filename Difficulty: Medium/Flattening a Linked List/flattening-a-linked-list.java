//{ Driver Code Starts
import java.util.*;

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

public class GFG {
    // Function to print the flattened linked list
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    // Create a linked list where `next` pointers connect the heads of multiple lists
    static Node createLinkedList(List<Node> lists) {
        Node head = null, temp = null;

        for (Node list : lists) {
            if (head == null) {
                head = list;
                temp = list;
            } else {
                temp.next = list;
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of test cases
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            // Read number of linked lists
            int n = Integer.parseInt(scanner.nextLine());
            List<Node> lists = new ArrayList<>();

            // Read each linked list
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] values = line.split(" ");
                Node head = null, temp = null;

                for (String value : values) {
                    Node newNode = new Node(Integer.parseInt(value));
                    if (head == null) {
                        head = newNode;
                        temp = head;
                    } else {
                        temp.bottom = newNode; // Corrected from `.next` to `.bottom`
                        temp = temp.bottom;
                    }
                }

                lists.add(head);
            }

            // Create a linked list connecting all heads using `next` pointers
            Node list = createLinkedList(lists);

            // Flatten the linked list using the solution
            Solution sol = new Solution();
            Node flattenedList = sol.flatten(list);

            // Print the flattened list
            printList(flattenedList);
            System.out.println("~");
        }

        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to flatten a linked list
    Node flatten(Node root) {
        if(root==null || root.next==null) return root;
            
        Node head1 = root;
        Node head2 = null;
        while(head1.next!=null) {
            head2 = head1.next.next;
            head1 = merge(head1, head1.next);
            head1.next = head2;
        }
        
        return root;
    }
    
    public static Node merge(Node head1, Node head2) {
        head1.next = null;
        
        Node head = head1;
        
        Node temp = head1;
        head1 = head1.bottom;
        while(head1!=null && head2!=null) {
            if(head1.data <= head2.data) {
                temp.bottom = head1;
                head1 = head1.bottom;
            } else {
                temp.bottom = head2;
                head2 = head2.bottom;
            }
            temp = temp.bottom;
        } 
        
        while(head1!=null) {
            temp.bottom = head1;
            head1 = head1.bottom;
            temp = temp.bottom;
        } 
        
        while(head2!=null) {
            temp.bottom = head2;
            head2 = head2.bottom;
            temp = temp.bottom;
        } 
        
        return head;
        
    }
}
