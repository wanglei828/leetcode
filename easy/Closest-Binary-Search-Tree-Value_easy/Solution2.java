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
        while(root != null) {
            if(Math.abs((double)root.val - target) < Math.abs((double)res - target)) {
                res = root.val;
            }
            root = (target > (double)root.val)? root.right : root.left;
        }
        return res;
    }
}
