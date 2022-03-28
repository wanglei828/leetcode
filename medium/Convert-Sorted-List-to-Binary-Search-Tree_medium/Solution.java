/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head, null);
    }
    
    private TreeNode helper(ListNode head, ListNode tail) {
        if(head == null || head == tail) return null;
        if(head.next == tail){
            TreeNode root = new TreeNode(head.val);
            return root;
        }
        ListNode mid = findMid(head, tail);
        TreeNode root = new TreeNode(mid.val);
        TreeNode left = helper(head, mid);
        TreeNode right = helper(mid.next, tail);
        root.left = left;
        root.right = right;
        return root;        
    }
    
    private ListNode findMid(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
