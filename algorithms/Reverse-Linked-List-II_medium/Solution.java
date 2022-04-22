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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        prev.next = head;
        while (left > 1) {
            prev = head;
            head = head.next;
            left--;
            right--;
        }
        ListNode con = prev;
        ListNode tail = head;
        while (right > 0) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            right--;
        }
        con.next = prev;
        tail.next = head;
        return dummy.next;
    }
}
