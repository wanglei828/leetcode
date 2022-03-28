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
        if (root == null) {
            return result;
        }
        if(root.left == null && root.right == null) {
            result.add(Integer.toString(root.val));
            return result;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for(String str: left) {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(root.val));
            sb.append("->");
            sb.append(str);
            result.add(sb.toString());
        }
        for(String str: right) {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(root.val));
            sb.append("->");
            sb.append(str);
            result.add(sb.toString());
        }
        return result;
    }
}
