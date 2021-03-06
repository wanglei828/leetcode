/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        root.next = null;
        TreeLinkNode head = root;
        while(head != null) {
            TreeLinkNode cur = head;
            TreeLinkNode newCur = null;
            head = null;
            while(cur != null) {
                if(cur.left != null) {
                    if(newCur == null) {
                        newCur = cur.left;
                        head = newCur;
                    } else {
                        newCur.next = cur.left;
                        newCur = newCur.next;
                    }
                }
                if(cur.right != null) {
                    if(newCur == null) {
                        newCur = cur.right;
                        head = newCur;
                    } else {
                        newCur.next = cur.right;
                        newCur = newCur.next;
                    }                    
                }
                cur = cur.next;
            }
        }
    }
}
