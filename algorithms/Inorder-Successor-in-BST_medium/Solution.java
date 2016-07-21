/*
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null.
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        if(p.right != null) {
            p = p.right;
            while(p.left != null) p = p.left;
            return p;
        } else {
            TreeNode parent = findParent(root, p);
            while(parent != null && parent.left != p) {
                p = parent;
                parent = findParent(root, p);
            }
            return parent;
        }
    }
    
    private TreeNode findParent(TreeNode root, TreeNode p) {
        if(root == null || root == p) return null;
        if(root.right == p || root.left == p) return root;
        TreeNode left = findParent(root.left, p);
        TreeNode right = findParent(root.right, p);
        return (left == null)? right : left;
    }
}
