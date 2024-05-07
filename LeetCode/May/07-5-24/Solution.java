/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public ListNode doubleIt(ListNode head) 
    {
        if (head.val >= 5)
            head = new ListNode(0, head);

        for (ListNode curr = head; curr != null; curr = curr.next) 
        {
            curr.val *= 2;
            curr.val %= 10;
            if (curr.next != null && curr.next.val >= 5)
                ++curr.val;
        }

        return head;
    }
}
