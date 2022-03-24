/*
Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, 
and every node has no left child and only one right child.

Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

Input: root = [5,1,7]
Output: [1,null,5,null,7]
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
    public TreeNode increasingBST(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        inorder(root, q);
        TreeNode dummy = new TreeNode();
        TreeNode cur = dummy;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            cur.right = node;
            cur.left = null;
            cur = node;           
        }
        cur.left = null;
        cur.right = null;
        return dummy.right;
    }
    
    private void inorder(TreeNode root, Queue<TreeNode> q) {
        if (root == null) return;
        inorder(root.left, q);
        q.add(root);
        inorder(root.right, q);
    }
}
