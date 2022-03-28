/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
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

    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if(target < (double)root.val) {
                    if(Math.abs(target - (double)res) >= Math.abs(target - (double)root.val)) {
                        res = root.val;
                    } else {
                        return res;
                    }
                } else if (target > root.val) {
                    res = root.val;
                } else {
                    return root.val;
                }
                root = root.right;
             }
        }
        return res;
    }
}
