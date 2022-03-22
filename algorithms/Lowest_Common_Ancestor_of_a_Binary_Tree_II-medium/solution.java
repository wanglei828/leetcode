/*
Given the root of a binary tree, return the lowest common ancestor (LCA) of two given nodes, p and q. 
If either node p or q does not exist in the tree, return null. All values of the nodes in the tree are unique.

According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a binary tree T is the lowest node 
that has both p and q as descendants (where we allow a node to be a descendant of itself)". 
A descendant of a node x is a node y that is on the path from node x to some leaf node.
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
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> path1 = new LinkedList<>();
        LinkedList<TreeNode> path2 = new LinkedList<>();
        boolean f1 = search(root, p, path1);
        boolean f2 = search(root, q, path2);
        TreeNode res = null;
        if (!f1 || !f2) {
            return null;
        } else {
            int i = 0, j = 0;
            while(i < path1.size() && j < path2.size()) {
                if (path1.get(i).val == path2.get(j).val) {
                    res = path1.get(i);
                    i++;
                    j++;
                } else {
                    break;
                }
            }
        }
        return res;
    }
    
    private boolean search(TreeNode root, TreeNode t, LinkedList<TreeNode> path) {
        path.add(root);
        if (root.val == t.val) return true;
        boolean find = false;
        if (root.left != null) {
            find = search(root.left, t, path);
        }
        if (find) {
            return true;
        }
        if (root.right != null) {
            find = search(root.right, t, path);
        }
        if (find) {
            return true;
        } else {
            path.removeLast();
            return false;
        }
    }
}
