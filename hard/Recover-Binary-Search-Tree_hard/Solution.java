/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;
    private void inorder(TreeNode root) {
        if(root == null) return;
        
        inorder(root.left);
        if(pre == null) {
            pre = root;
        } else {
            if(pre.val > root.val) {
                if(first == null) {
                    first = pre;
                }
                second = root;
            }
            pre = root;
        }
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(first != null && second != null) {
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }
}
