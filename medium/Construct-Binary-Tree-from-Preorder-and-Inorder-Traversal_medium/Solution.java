/*
Given preorder and inorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)  return null;
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] preorder, int ps, int pe, int[] inorder, int ins, int ine) {
        if(ps > pe || ins > ine) {
            return null;
        }
        int pv = preorder[ps];
        int find = 0;
        for(int i=ins; i<=ine; i++) {
            if(pv == inorder[i]) {
                find = i;
                break;
            }
        }
        TreeNode left = helper(preorder, ps+1, ps+find-ins, inorder, ins, find-1);
        TreeNode right = helper(preorder, ps+find-ins+1, pe, inorder, find+1, ine);
        TreeNode root = new TreeNode(pv);
        root.right = right;
        root.left = left;
        return root;
    }
}
