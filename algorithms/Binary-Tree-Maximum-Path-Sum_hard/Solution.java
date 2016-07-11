/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int res = helper(root);
        max = Math.max(max, res);
        return max;
    }
    
    private int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int sum = left + right + root.val;
        left += root.val;
        right += root.val; 
        max = Math.max(max, left);
        max = Math.max(max, right);
        max = Math.max(max, sum);
        max = Math.max(max, root.val);
        return Math.max(root.val, Math.max(right, left));
    }
}
