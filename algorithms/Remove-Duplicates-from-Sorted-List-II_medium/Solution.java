/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode dup = null;
        ListNode cur = head;
        ListNode next = cur.next;
        while(next!= null) {
            if(cur.val == next.val) {
                dup = cur;
                cur.next = next.next;
                next = cur.next;
            } else {
                if(dup == null) {
                    pre = cur;
                    cur = next;
                    next = cur.next;
                } else {
                    pre.next = next;
                    cur = next;
                    next = cur.next;
                    dup = null;
                }
            }
            if(next == null && dup != null) {
                pre.next = null;
                break;
            }
        }
        return dummy.next;
    }
}
