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
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        root.left = null;
        TreeNode cur = root;
        while(left != null) {
            cur.right = left;
            cur = left;
            left = left.right;
        }
        cur.right = right;
        return root;
    }
}
