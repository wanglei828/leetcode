Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Note: 

1 <= preorder.length <= 100
The values of preorder are distinct.
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, 0, preorder.length-1);
    }
    
    private TreeNode buildTree(int[] nums, int i, int j) {
        if(i > j) return null;
        int cur = nums[i];
        TreeNode root = new TreeNode(cur);
        int t = i+1;
        while(t<=j) {
            if(nums[t] > cur) {
                break;
            }
            t++;
        }
        root.left = buildTree(nums, i+1, t-1);
        root.right = buildTree(nums, t, j);
        return root;
    }
}
