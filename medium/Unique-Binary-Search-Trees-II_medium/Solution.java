/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        if(n== 0) return (new ArrayList<TreeNode>());
        return helper(1,n);
    }
    
    private List<TreeNode> helper(int s, int e) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(s > e){
            list.add(null);
            return list;
        }
        for(int i=s; i<=e; i++) {
            List<TreeNode> leftList = helper(s, i-1);
            List<TreeNode> rightList = helper(i+1, e);
            for(TreeNode left: leftList) {
                for(TreeNode right: rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
