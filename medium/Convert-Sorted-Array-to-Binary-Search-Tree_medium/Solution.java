/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }
    
    private TreeNode buildTree(int[] nums, int h, int t) {
        if(h > t) return null;
        TreeNode root;
        if(h == t) {
            root = new TreeNode(nums[h]);
        } else {
            int mid = h + (t-h)/2;
            root = new TreeNode(nums[mid]);
            TreeNode left = buildTree(nums, h, mid-1);
            TreeNode right = buildTree(nums, mid+1, t);
            root.left = left;
            root.right = right;
        }
        return root;
    }
}
