/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int ins, int ine, int[] postorder, int ps, int pe) {
        if( ins > ine || ps > pe ) return null;
        int rv = postorder[pe];
        int find = 0;
        for(int i=ins; i<= ine; i++) {
            if(inorder[i] == rv) {
                find = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rv);
        TreeNode right = helper(inorder, find+1, ine, postorder, pe-(ine-find), pe-1);
        TreeNode left = helper(inorder, ins, find-1, postorder, ps, pe-(ine-find)-1);
        root.right = right;
        root.left = left;
        return root;
    }
}
