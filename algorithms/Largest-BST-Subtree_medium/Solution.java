/*
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), 
where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.
Here's an example:
    10
    / \
   5  15
  / \   \ 
 1   8   7
The Largest BST Subtree in this case is the highlighted one. 
The return value is the subtree's size, which is 3.

Follow up:
Can you figure out ways to solve it with O(n) time complexity?
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
 class Result {
     long max = Long.MIN_VALUE;
     long min = Long.MAX_VALUE;
     int count = 0;
     boolean bst = true;
 }
public class Solution {
    int res = 0;
    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return res;
    }
    private Result helper(TreeNode root) {
        if(root == null) return null;
        Result left = helper(root.left);
        Result right = helper(root.right);
        Result cur = new Result();
        if(left == null) {
            left = new Result();
        }
        if(right == null) {
            right = new Result();
        }
        if(!left.bst || !right.bst) {
            cur.bst = false;
        } else {
            if(left.max < root.val && right.min > root.val) {
                cur.count = 1 + left.count + right.count;
                cur.bst = true;
                cur.max = Math.max(root.val, right.max);
                cur.min = Math.min(root.val, left.min);
                res = Math.max(res, cur.count);
            } else {
                cur.bst = false;
            }
        }
        return cur;
    }
}
