/*
Given the root of a binary tree, find the maximum value v for which 
there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation: We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3

Input: root = [1,null,2,null,0,3]
Output: 3
 

Constraints:

The number of nodes in the tree is in the range [2, 5000].
0 <= Node.val <= 105
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
    int res;
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        res = 0;
        traverse(root, root.val, root.val);
        return res;   
    }
    
    private void traverse(TreeNode root, int max, int min) {
        if (root == null) return;
        res = Math.max(res, Math.abs(max - root.val));
        res = Math.max(res, Math.abs(min - root.val));
        traverse(root.right, Math.max(max, root.val), Math.min(min, root.val));
        traverse(root.left, Math.max(max, root.val), Math.min(min, root.val));
    }
}
