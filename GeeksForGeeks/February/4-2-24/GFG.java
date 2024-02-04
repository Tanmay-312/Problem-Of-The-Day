//{ Driver Code Starts
import java.util.Scanner;

// Node Class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Linked List Class
class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // creates a new node with given value and appends it at the end of the linked list
    void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}


public class Main {
    static void printList(Node n) 
    {
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            LinkedList LL1 = new LinkedList();
            String l1 = sc.next();
            for (int j = 0; j < n; ++j) {
                int x = Character.getNumericValue(l1.charAt(j));
                LL1.insert(x);
            }

            int m = sc.nextInt();
            LinkedList LL2 = new LinkedList();
            String l2 = sc.next();
            for (int j = 0; j < m; ++j) {
                int x = Character.getNumericValue(l2.charAt(j));
                LL2.insert(x);
            }

            Solution ob = new Solution();
            Node res = ob.subLinkedList(LL1.head, LL2.head);
            printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution 
{
    public Node subLinkedList(Node head1, Node head2) 
    {
        // code here
        while(head1!=null && head1.data==0)
            head1=head1.next;
        
        while(head2!=null && head2.data==0)
            head2=head2.next;
         
        int s1 = getLength(head1), s2 = getLength(head2);
        
        if(s1==0 && s2==0)
            return new Node(0);
         
        if(s2>s1)
        {
            Node temp = head1; head1=head2; head2=temp;  
        }
        if(s1==s2)
        {
            Node curr1 = head1, curr2=head2;
            while(curr1.data==curr2.data)
            {
                curr1=curr1.next; curr2=curr2.next;
                 
                if(curr1==null)
                    return new Node(0);
            }
            if(curr2.data > curr1.data)
            {
                Node temp = head1; head1=head2; head2=temp;  
            }
        }
        
        head1 = reverse(head1);
        head2=reverse(head2);
        Node ans = null;
        while(head1!=null)
        {
            int n1 = head1.data;
            int n2=0;
            if(head2!=null)
                n2= head2.data;
            
            if(n1<n2)
            {
                if(head1.next!=null)
                {
                    head1.next.data -= 1;
                }
                n1+=10;
            }
         
            Node curr = new Node(n1-n2);
            curr.next = ans;
            ans = curr;
            
            head1 = head1.next;
            if(head2!=null)
                head2 = head2.next;
        }
            
      
        while(ans!=null && ans.next != null )
        {
            if(ans.data==0)
            {
               ans = ans.next;
            }
            else
                break;
        }
        return ans;
    }
    
    
    int getLength(Node head)
    {
        int cnt=0;  
        for(Node curr=head; curr!=null;  curr=curr.next)
            cnt++;
        return cnt;
    }
    
    
    Node reverse(Node head)
    {
        Node prev=null, curr=head, next=null;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev; 
    }
}
        
