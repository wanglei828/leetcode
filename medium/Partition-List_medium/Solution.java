/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode head, int x) {
        if(head == null) return null;
        ListNode lessH = null;
        ListNode less = null;
        ListNode great = null;
        ListNode greatH = null;
        while(head != null) {
            if(head.val < x) {
                if(less == null) {
                    less = head;
                    lessH = less;
                } else {
                    less.next = head;
                    less = less.next;
                }
                
            } else {
                if(great == null) {
                    great = head;
                    greatH = great;
                } else {
                    great.next = head;
                    great = great.next;
                }
            }
            head = head.next;
        }
        if(less != null) {
            less.next = greatH;
        }
        if(great != null) {
            great.next = null;
        }
        return (lessH == null)? greatH : lessH;
    }
}
