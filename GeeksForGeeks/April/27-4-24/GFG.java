//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next, prev;

    Node(int key) {
        data = key;
        next = prev = null;
    }
}

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;

            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                Node n1 = new Node(a);
                n1.prev = temp;
                temp.next = n1;
                temp = n1;
            }

            head = new Solution().sortDoubly(head);
            printList(head);
        }
    }

    public static void printList(Node node) {
        Node temp = node;
        while (node != null) {
            System.out.print(node.data + " ");
            temp = node;
            node = node.next;
        }
        System.out.println();
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next, prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}
*/
class Solution 
{
    // Function to sort the given doubly linked list using Merge Sort.
    static Node sortDoubly(Node head) 
    {
        // add your code here
        ArrayList<Integer> arr=new ArrayList<>();
        Node curr1=head;
        
        while(curr1.next!=null)
        {
            arr.add(curr1.data);
            curr1=curr1.next;
        }
        
        arr.add(curr1.data);
        Collections.sort(arr);
        Node curr=head;
        
        for(int i=0;i<arr.size();i++)
        {
            curr.data=arr.get(i);
            curr=curr.next;
        }
        return head;
    }
}
