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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        long pre = Long.MIN_VALUE;
        while(!s.isEmpty() || root != null) {
            if(root != null) {
                s.push(root);
                root = root.left;
            } else {
                root = s.pop();
                if((long)root.val <= pre) {
                    return false;
                } 
                pre = (long)root.val;
                root = root.right;
            }
        }
        return true;
    }
}
