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
        if(root == null || p == null) return null;
        TreeNode res = null;
        if(p.right != null) {
            res = p.right;
            while(res.left != null) {
                res = res.left;
            }
            return res;
        } else {
            if(root == p) return null;
            TreeNode parent =  findParent(root, p);
            while(parent.left != p) {
                p = parent;
                if(p == root) {
                    return null;
                }
                parent = findParent(root, p);
            }
            return parent;
        }
    }
    private TreeNode findParent(TreeNode root, TreeNode p) {
        if(root.left == p || root.right == p) return root;
        TreeNode res = null;
        if(root.left != null) {
            res = findParent(root.left, p);
        }
        if(res != null) return res;
        if(root.right != null) {
            res = findParent(root.right, p);
        }
        return res;
    }
}
