/*
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), 
where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.
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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<TreeNode, Integer>(root, 0));
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int begin = q.peek().getValue();
            Pair<TreeNode, Integer> cur = null;
            for (int i = 0; i < size; i++) {
                cur = q.poll();
                TreeNode node = cur.getKey();
                int value = cur.getValue();
                if (node.left != null) {
                    q.add(new Pair<>(node.left, value*2));
                }
                if (node.right != null) {
                    q.add(new Pair<>(node.right, value*2+1));
                }
            }
            ans = Math.max(ans, cur.getValue() - begin + 1);
        }
        return ans;
    }
}
