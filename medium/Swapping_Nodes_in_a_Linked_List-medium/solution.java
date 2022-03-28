/*
You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int n = 0;
        ListNode cur = head;
        ListNode knode = null;
        while(cur != null) {
            n++;
            if (n == k) {
                knode = cur;
            }
            cur = cur.next;
        }
        cur = head;
        ListNode nknode = null;
        int cnt = 0;
        while(cur != null) {
            cnt++;
            if (cnt == n-k+1) {
                nknode = cur;
                break;
            }
            cur = cur.next;
        }
        int tmp = knode.val;
        knode.val = nknode.val;
        nknode.val = tmp;
        return head;
    }
}
