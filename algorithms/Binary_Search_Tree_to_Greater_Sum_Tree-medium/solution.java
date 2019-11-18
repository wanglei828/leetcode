/*

Given the root of a binary search tree with distinct values, modify it so that every node has a new value equal to the sum of the values of the original tree that are greater than or equal to node.val.

As a reminder, a binary search tree is a tree that satisfies these constraints:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Note:

The number of nodes in the tree is between 1 and 100.
Each node will have value between 0 and 100.
The given tree is a binary search tree.
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
class Solution {
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> s = new Stack<>();
        int sum = 0;
        TreeNode cur = root;
        while(!s.isEmpty() || cur != null) {
            if(cur != null) {
                s.push(cur);
                cur = cur.right;
            } else {
                cur = s.pop();
                cur.val += sum;
                sum = cur.val;
                cur = cur.left;
            }
        }
        return root;
    }
}
