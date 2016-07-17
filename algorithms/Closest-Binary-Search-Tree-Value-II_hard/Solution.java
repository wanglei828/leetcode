/*
Given a non-empty binary search tree and a target value, 
find k values in the BST that are closest to the target.

Note:
Given target value is a floating point.
You may assume k is always valid, that is: k ≤ total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Follow up:
Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if(res.size() < k) {
                    res.add(root.val);
                } else {
                    if(target < (double)res.get(0)) {
                        return res;
                    } else if(target > (double)root.val) {
                        res.remove(0);
                        res.add(root.val);
                    } else if(target <= (double)root.val) {
                        if(Math.abs(target - (double)res.get(0)) >= Math.abs(target - (double)root.val) ) {
                            res.remove(0);
                            res.add(root.val);
                        } else {
                            return res;
                        }
                        
                    }
                }
                root = root.right;
            }
        }
        return res;
    }
}
