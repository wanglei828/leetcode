/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Stack<TreeNode> sl = new Stack<TreeNode>();
        Stack<TreeNode> sr = new Stack<TreeNode>();
        sl.add(root);
        List<Integer> list = new ArrayList<Integer>();
        while(!sl.isEmpty() || !sr.isEmpty()) {
            while(!sl.isEmpty()) {
                TreeNode tmp = sl.pop();
                if(tmp.left != null) {
                    sr.push(tmp.left);
                }
                if(tmp.right != null) {
                    sr.push(tmp.right);
                }
                list.add(tmp.val);
            }
            if(list.size() > 0) {
                res.add(list);
                list = new ArrayList<Integer>();
            }
            while(!sr.isEmpty()) {
                TreeNode tmp = sr.pop();
                if(tmp.right != null) {
                    sl.push(tmp.right);
                }
                if(tmp.left != null) {
                    sl.push(tmp.left);
                }
                list.add(tmp.val);
            }
            if(list.size() > 0) {
                res.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return res;
    }
}
