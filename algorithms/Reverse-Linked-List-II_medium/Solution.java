/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n) return head;
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode pre = dum;
        while(m !=1) {
            pre = head;
            head = head.next;
            m--;
            n--;
        }
        ListNode tail = head;
        ListNode next = head.next;
        ListNode cur = head;
        head = pre;
        pre = null;
        while(n != 0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }
        head.next = pre;
        tail.next = cur;
        return dum.next;
    }
}
