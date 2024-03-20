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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) 
    {
        ListNode nodeBeforeA = list1;
        for (int i = 0; i < a - 1; ++i)
            nodeBeforeA = nodeBeforeA.next;

        ListNode nodeB = nodeBeforeA.next;
        for (int i = 0; i < b - a; ++i)
            nodeB = nodeB.next;

        nodeBeforeA.next = list2;
        ListNode lastNodeInList2 = list2;

        while (lastNodeInList2.next != null)
            lastNodeInList2 = lastNodeInList2.next;

        lastNodeInList2.next = nodeB.next;
        nodeB.next = null;
        return list1;
    }
}
