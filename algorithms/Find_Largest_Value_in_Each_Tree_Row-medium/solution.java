/*

You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode cur = q.poll();
                max = Math.max(cur.val, max);
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
            res.add(max);
        }
        return res;
    }
}
