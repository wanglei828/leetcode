/*
Reverse a singly linked list.
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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        cur.next = pre;
        while(next != null) {
            pre = cur;
            cur = next;
            next = next.next;
            cur.next = pre;
        }
        return cur;
    }
}
