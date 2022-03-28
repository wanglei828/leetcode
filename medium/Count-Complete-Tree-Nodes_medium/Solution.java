/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left = leftHeight(root.left);
        int right = rightHeight(root.right);
        if(left == right) {
            return (1<<(left+1)) -1;
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    private int leftHeight(TreeNode root) {
        if(root == null) return 0;
        int h=1;
        while(root.left != null) {
            h++;
            root = root.left;
        }
        return h;
    }
    private int rightHeight(TreeNode root) {
        if(root == null) return 0;
        int h=1;
        while(root.right != null) {
            h++;
            root = root.right;
        }
        return h;       
    }
}
