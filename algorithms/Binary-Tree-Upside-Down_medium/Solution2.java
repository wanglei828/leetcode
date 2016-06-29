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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) return root;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode curL = root.left;
        TreeNode curR = root.right;
        root.left = left;
        root.right = right;
        while(curL != null) {
            left = curR;
            right = root;
            root = curL;
            curL = root.left;
            curR = root.right;
            root.left = left;
            root.right = right;
        }
        return root;
    }
}
