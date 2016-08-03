/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode res = new ListNode(0);
        int carry = 0;
        ListNode pre = res;
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            l1.val = sum%10;
            pre.next = l1;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode l = (l1 == null)? l2 : l1;
        while(carry != 0 && l != null) {
            int sum = l.val + carry;
            l.val = sum%10;
            carry = sum/10;
            pre.next = l;
            pre = pre.next;
            l = l.next;
        }
        if(carry == 1) {
            pre.next = new ListNode(1);
        } else {
            pre.next = l;
        }
        return res.next;
    }
}
