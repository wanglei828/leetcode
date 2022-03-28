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
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        while(m!=1) {
            m--;
            n--;
            pre = head;
            head = head.next;
        }
        ListNode bef = null;
        ListNode cur = head;
        ListNode next = null;
        while(n !=0) {
            next = cur.next;
            cur.next = bef;
            bef = cur;
            cur = next;
            n--;
        }
        pre.next = bef;
        head.next = cur;
        return res.next;
    }
}
