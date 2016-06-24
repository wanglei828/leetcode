/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode res = new ListNode(-1);
        ListNode pre = res;
        ListNode cur = head;
        ListNode next = cur.next;
        while(cur != null && next != null) {
            cur.next = next.next;
            next.next = cur;
            pre.next = next;
            
            pre = cur;
            cur = cur.next;
            if(cur != null) {
                next = cur.next;
            } else {
                next = null;
            }
        }
        return res.next;
    }
}
