//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}

class GFG {
    static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	public static void main (String[] args) {
		Scanner sc  = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    
		    Node head = new Node(sc.nextInt());
		    Node tail = head;
		    
		    for(int i=1; i<n; i++){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		    Solution obj = new Solution();
		    head = obj.sort(head);
		    printList(head);
		}
	}
}

// } Driver Code Ends



/*
class Node {
    int data;
    Node next;
    
    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution 
{
    
   public Node sort(Node head)
   {
        //your code here, return the head of the sorted list
        if(head==null||head.next==null)
            return head;
        
        Node t=head;
        Node n1=new Node(-1);
        Node n2=new Node(-1);
        Node p1=n1,p2=n2;
        
        while(t!=null&&t.next!=null)
        {
            p1.next=t;
            p1=t;
            p2.next=t.next;
            p2=t.next;
            
            if(t.next!=null)
                t=t.next.next;
            else
                break;
        }
        
        Node nh=n2.next;
        n2.next=null;
        p1.next=rev(nh);
        
        return n1.next;
   }
   
   
   public static Node rev(Node h)
   {
       Node pr=null;
       while(h!=null)
       {
           Node n=h.next;
           h.next=pr;
           pr=h;
           h=n;
       }
       return pr;
   }
}
