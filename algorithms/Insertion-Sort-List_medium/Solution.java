/*
Sort a linked list using insertion sort.
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
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode next = head.next;
        head.next = null;
        head = next;
        while(head != null) {
            ListNode cur = res.next;
            ListNode pre = res;
            next = head.next;
            while(cur != null) {
                if(cur.val <= head.val) {
                    pre = cur;
                    cur = cur.next;
                } else {
                    pre.next = head;
                    pre = head;
                    pre.next = cur;
                    break;
                }
            }
            if(cur == null) {
                pre.next = head;
                head.next = null;
            }
            head = next;
        }
        return res.next;
    }
}
