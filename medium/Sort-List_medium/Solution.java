/*
Sort a linked list in O(n log n) time using constant space complexity.
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = getMid(head);
        ListNode firstHalf = head;
        ListNode secondHalf = mid.next;
        mid.next = null;
        firstHalf = sortList(firstHalf);
        secondHalf = sortList(secondHalf);
        return merge(firstHalf, secondHalf);
    }
    
    private ListNode merge(ListNode first, ListNode second) {
        if(first == null) return second;
        if(second == null) return first;
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        ListNode pre = dummy;
        while(first != null && second != null) {
            if(first.val <= second.val) {
                pre.next = first;
                pre = first;
                first = first.next;
            } else {
                pre.next = second;
                pre = second;
                second = second.next;
            }
        }
        pre.next = (first == null)? second : first;
        return dummy.next;
    }
    
    private ListNode getMid(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
