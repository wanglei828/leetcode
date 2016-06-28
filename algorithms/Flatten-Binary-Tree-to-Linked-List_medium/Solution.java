/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        List<TreeNode> list = new ArrayList<TreeNode>();
        while(!s.isEmpty() || root != null) {
            if(root != null) {
                list.add(root);
                if(root.right != null) {
                    s.push(root.right);
                }
                root = root.left;
            } else {
                root = s.pop();
            }
        }
        for(int i=0; i<list.size()-1; i++) {
            TreeNode tmp = list.get(i);
            tmp.right = list.get(i+1);
            tmp.left = null;
        }
        list.get(list.size()-1).right = null;
        list.get(list.size()-1).left = null;
    }
}
