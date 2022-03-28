/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        Stack<Integer> s = new Stack<Integer>();
        ListNode iter = head;
        while(iter != null) {
            s.push(iter.val);
            iter = iter.next;
        }
        iter = head;
        while(iter != null) {
            if(iter.val != s.pop()) {
                return false;
            }
            iter = iter.next;
        }
        return true;
    }
}
