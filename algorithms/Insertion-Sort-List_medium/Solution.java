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
        if(head == null) return null;
        ListNode res = new ListNode(-1);
        res.next = null;
        ListNode iter = res;
        while(head != null) {
            if(iter == res) {
                iter.next = head;
                iter = iter.next;
                head = head.next;
                iter.next = null;
                continue;
            }
            ListNode pre = res;
            ListNode cur = res.next;
            while(cur != null) {
                if(cur.val >= head.val) {
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
            pre.next = head;
            ListNode next = head.next;
            head.next = cur;
            head = next;
            if(cur == null) {
                iter = pre.next;
            }
        }
        iter.next = null;
        return res.next;
    }
}

