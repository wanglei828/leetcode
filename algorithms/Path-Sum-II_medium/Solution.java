/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
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
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, sum, list);
        return res;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> list) {
        if(root == null) return;
        if(root.left == null && root.right == null && root.val == sum) {
            List<Integer> copy = new ArrayList<Integer>();
            for(Integer item : list) {
                copy.add(item);
            }
            copy.add(root.val);
            res.add(copy);
            return;
        }
        int size = list.size();
        list.add(root.val);
        helper(root.left, sum-root.val, list);
        helper(root.right, sum-root.val, list);
        list.remove(size);     
    }
}
