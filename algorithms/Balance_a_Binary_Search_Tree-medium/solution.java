/*
Given the root of a binary search tree, return a balanced binary search tree with the same node values. 
If there is more than one answer, return any of them.

A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.
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
    List<Integer> nums;
    HashMap<Integer, TreeNode> map;
    public TreeNode balanceBST(TreeNode root) {
        if (root == null) return null;
        nums = new ArrayList<Integer>();
        map = new HashMap<>();
        inorder(root);
        return buildTree(0, nums.size()-1);
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        nums.add(root.val);
        map.put(root.val, root);
        inorder(root.right);
    }
    
    private TreeNode buildTree(int s, int e) {
        if (e < s) return null;
        int m = s + (e-s)/2;
        int val = nums.get(m);
        TreeNode root = map.get(val);
        root.left = buildTree(s, m-1);
        root.right = buildTree(m+1, e);
        return root;
    }
}

