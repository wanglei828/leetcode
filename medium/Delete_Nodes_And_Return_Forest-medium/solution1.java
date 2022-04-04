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
    List<TreeNode> res;
    Set<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        set = new HashSet<>();
        for(int i : to_delete) {
            set.add(i);
        }
        root = traverse(root);
        if (root != null) {
            res.add(root);
        }
        return res;
    }
    
    private TreeNode traverse(TreeNode root) {
        if (root == null) return null;
        TreeNode left = traverse(root.left);
        TreeNode right = traverse(root.right);
        if (set.contains(root.val)) {
            if (left != null) {
                res.add(left);
            }
            if (right != null) {
                res.add(right);
            }
            return null;
        } else {
            root.left = left;
            root.right = right;
            return root;
        }
    }
}
