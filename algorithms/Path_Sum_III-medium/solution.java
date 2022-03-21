/*
Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int cnt = 0;
    HashMap<Integer, Integer> preSum;
    public int pathSum(TreeNode root, int targetSum) {
        preSum = new HashMap<>();
        helper(root, 0, targetSum);
        return cnt;
    }
    
    private void helper(TreeNode node, int before, int target) {
        if (node == null) return;
        int cur = node.val + before;
        if (cur == target) cnt++;
        if (preSum.containsKey(cur - target)) {
            cnt += preSum.get(cur - target);
        }
        if (preSum.containsKey(cur)) {
            preSum.put(cur, preSum.get(cur) + 1);
        } else {
            preSum.put(cur, 1);
        }
        
        helper(node.left, cur, target);
        helper(node.right, cur, target);
        
        preSum.put(cur, preSum.get(cur) - 1);       
    }
}
