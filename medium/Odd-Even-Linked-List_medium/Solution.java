/*
Given a singly linked list, group all odd nodes together followed by the even nodes. 
Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. 
The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...

Credits:
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode evenH = null;
        ListNode even = null;
        ListNode oddH = null;
        ListNode odd = null;
        int round = 0;
        while(head != null) {
           if (round == 0) {
             if (even == null) {
                even = head;
                evenH = head;
             } else {
                even.next = head;
                even = even.next;
             }
             round = 1;
           } else {
             if (odd == null) {
                odd = head;
                oddH = head;
             } else {
                odd.next = head;
                odd = odd.next;
             }
             round = 0;
           }
           head = head.next;
        }
        even.next = oddH;
        odd.next = null;
        return evenH;
    }
}
