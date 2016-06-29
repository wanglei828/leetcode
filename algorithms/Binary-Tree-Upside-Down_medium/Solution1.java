/*
Given a binary tree where all the right nodes are either leaf nodes with a sibling 
(a left node that shares the same parent node) or empty, 
flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. 
Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  
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
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) return root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode res = null;
        while(!s.isEmpty() || root != null) {
            if(root != null) {
                s.push(root);
                root = root.left;
            } else {
                root = s.pop();
                if(res == null) {
                    res = root;
                }
                if(s.isEmpty()) {
                    root.left =  null;
                    root.right = null;
                    break;
                }
                TreeNode parent = s.peek();
                if(parent.right != null) {
                    root.left = parent.right;
                }
                root.right = parent;
                parent.left = null;
                parent.right = null;
                root = null;
            }
        }
        return res;
    }
}
