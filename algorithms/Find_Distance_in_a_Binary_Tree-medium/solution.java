/*
Given the root of a binary tree and two integers p and q, return the distance between the nodes of value p and value q in the tree.

The distance between two nodes is the number of edges on the path from one to the other.

Constraints:

The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
All Node.val are unique.
p and q are values in the tree.
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
    public int findDistance(TreeNode root, int p, int q) {
        LinkedList<Integer> path1 = new LinkedList<>();
        find(root, p, path1);
        LinkedList<Integer> path2 = new LinkedList<>();
        find(root, q, path2);    
        while (!path1.isEmpty() && !path2.isEmpty()) {
            int p1 = path1.peek();
            int p2 = path2.peek();
            if (p1 == p2) {
                path1.pollFirst();
                path2.pollFirst();
            } else {
                break;
            }
        }
        return path1.size() + path2.size();
    }
    
    private boolean find(TreeNode root, int tar, LinkedList<Integer> path) {
        if (root == null) return false;
        if (root.val == tar) {
            path.add(root.val);
            return true;
        }
        path.add(root.val);
        boolean found = find(root.left, tar, path);
        if (found) {
            return true;
        }
        found = find(root.right, tar, path);
        if (found) {
            return true;
        } else {
            path.pollLast();
            return false;
        }
    }
}
