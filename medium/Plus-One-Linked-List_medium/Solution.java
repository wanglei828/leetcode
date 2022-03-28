/*
Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
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
    public ListNode plusOne(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode not9 = dummy;
        while(head != null) {
            if(head.val != 9) {
                not9 = head;
            }
            head = head.next;
        }
        not9.val += 1;
        not9 = not9.next;
        while(not9 != null) {
            not9.val = 0;
            not9 = not9.next;
        }
        return (dummy.val == 1)? dummy : dummy.next;
    }
}
