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
    int res = -1;
    double min = Double.POSITIVE_INFINITY;
    public int closestValue(TreeNode root, double target) {
        if((double)(root.val) == target) {
            min = 0;
            res = root.val;
            return res;
        }
        if(min > Math.abs((double)(root.val) - target)) {
            min = Math.abs((double)(root.val) - target);
            res = root.val;
        }
        if(target > (double)root.val && root.right != null) {
            closestValue(root.right, target);
        } else if(target < (double)root.val && root.left != null) {
            closestValue(root.left, target);
        } 
        return res;
    }
}
