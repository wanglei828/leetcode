/*
Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        List<String> right = null;
        List<String> left = null;
        if (root == null) {
            return result;
        }
        if(root.left == null && root.right == null) {
            result.add(Integer.toString(root.val));
            return result;
        }
        if(root.left != null) {
            left = binaryTreePaths(root.left);
        }
        if(root.right != null) {
            right = binaryTreePaths(root.right);
        }
        if(left != null) {
            for(int i = 0; i < left.size(); i++) {
                String item = left.get(i);
                StringBuilder sb = new StringBuilder();
                sb.append(Integer.toString(root.val));
                sb.append("->");
                sb.append(item);
                result.add(sb.toString());
            }
        }
        if(right != null) {
            for(int i = 0; i < right.size(); i++) {
                String item = right.get(i);
                StringBuilder sb = new StringBuilder();
                sb.append(Integer.toString(root.val));
                sb.append("->");
                sb.append(item);
                result.add(sb.toString());
            }
        }
        return result;
    }
}
