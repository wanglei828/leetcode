/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return Integer.MIN_VALUE;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(!s.isEmpty() || root != null) {
            if(root != null) {
                s.push(root);
                root = root.left;
            } else {
                TreeNode tmp = s.pop();
                k--;
                if(k==0) {
                    return tmp.val;
                }
                root = tmp.right;
            }
        }
        return Integer.MIN_VALUE;
    }
}
