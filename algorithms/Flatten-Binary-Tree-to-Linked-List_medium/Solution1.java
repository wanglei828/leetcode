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
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.right = null;
        root.left = null;
        if(right == null && left == null) {
            return root;
        }
        TreeNode rl = helper(left);
        TreeNode rr = helper(right);
        TreeNode cur = root;
        while(rl != null) {
            cur.right = rl;
            cur = rl;
            rl = rl.right;
        }
        cur.right = rr;
        return root;
    }
}
