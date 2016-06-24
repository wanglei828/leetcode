/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode result = new ListNode(-1);
        result.next = head;
        ListNode cur = head;
        for(int i=1; i<n; i++) {
            cur = cur.next;
        }
        ListNode pre = result;
        while(cur.next != null) {
            pre = pre.next;
            head = head.next;
            cur = cur.next;
        }
        pre.next = head.next;
        return result.next;
    }
}
