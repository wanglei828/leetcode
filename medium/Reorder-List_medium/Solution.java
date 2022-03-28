/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
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
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode first = head;
        ListNode second = slow.next;
        slow.next = null;
        slow = null;
        ListNode cur = second;
        while(cur!=null) {
            fast = cur.next;
            cur.next = slow;
            slow = cur;
            cur = fast;
        }
        second = slow;
        ListNode dummy = new ListNode(-1);
        cur = dummy;
        while(first != null && second != null) {
            slow = first.next;
            fast = second.next;
            cur.next = first;
            first.next = second;
            cur = second;
            first = slow;
            second = fast;
        }
        cur.next = (first == null)? second : first;
    }
}
