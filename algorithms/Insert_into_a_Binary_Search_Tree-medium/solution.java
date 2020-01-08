/*

Given the root node of a binary search tree (BST) and a value to be inserted into the tree, 
insert the value into the BST. Return the root node of the BST after the insertion. 
It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, 
as long as the tree remains a BST after insertion. You can return any of them.

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
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        traverse(root, val);
        return root;
    }
    
    private void traverse(TreeNode cur, int val) {
        if(cur.val < val) {
            if(cur.right != null) {
                traverse(cur.right, val);
            } else {
                cur.right = new TreeNode(val);
            }
        } else {
            if(cur.left != null) {
                traverse(cur.left, val);
            } else {
                cur.left = new TreeNode(val);
            }
        }
    }
}
