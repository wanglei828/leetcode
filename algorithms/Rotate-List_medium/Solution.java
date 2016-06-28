/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode next = head;
        ListNode tail = null;
        int n = 0;
        while(next != null) {
            n++;
            tail = next;
            next = next.next;
        }
        k = k%n;
        if(k == 0) return head;
        int count = n - k;
        next = head;
        while(count != 1) {
            next = next.next;
            count--;
        }
        tail.next = head;
        head = next.next;
        next.next = null;
        return head;
    }
}
