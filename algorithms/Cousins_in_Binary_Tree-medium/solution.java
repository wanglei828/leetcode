/*
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, 
return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.
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
    public boolean isCousins(TreeNode root, int x, int y) {
        LinkedList<Integer> path1 = new LinkedList<>();
        LinkedList<Integer> path2 = new LinkedList<>();
        find(root, x, path1);
        find(root, y, path2);
        int size1 = path1.size();
        int size2 = path2.size();
        if (size1 != size2) return false;
        if (size1 <= 2 || size2 <= 2) return false;
        return path1.get(size1 - 2) != path2.get(size2 - 2);
    }
    
    private boolean find(TreeNode root, int v, LinkedList<Integer> path) {
        if(root == null) return false;
        if (root.val == v) {
            path.add(root.val);
            return true;
        }
        path.addLast(root.val);
        if (find(root.left, v, path)) {
            return true;
        }
        if (find(root.right, v, path)) {
            return true;
        }
        path.removeLast();
        return false;
    }
}
