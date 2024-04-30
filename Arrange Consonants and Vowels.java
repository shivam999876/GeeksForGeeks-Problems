//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    public Node arrangeCV(Node head){
        Node vowelHead = new Node('0');
        Node consHead = new Node('0');
        Node v = vowelHead,c = consHead;
        while(head!=null){
            if(isVowel(head.data)){
                v.next = head;
                v = v.next;
            }
            else{
                c.next = head;
                c = c.next;
            }
            head = head.next;
        }
        v.next = consHead.next;
        c.next = null;
        return vowelHead.next;
    }
    static boolean isVowel(char c){
        return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
    }
}
