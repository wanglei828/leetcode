/*
Given the root of a binary tree, return the number of nodes where the value of the node is equal to the sum of the values of its descendants.

A descendant of a node x is any node that is on the path from node x to some leaf node. 
The sum is considered to be 0 if the node has no descendants.

Input: root = [10,3,4,2,1]
Output: 2
Explanation:
For the node with value 10: The sum of its descendants is 3+4+2+1 = 10.
For the node with value 3: The sum of its descendants is 2+1 = 3.

Input: root = [2,3,null,2,null]
Output: 0
Explanation:
No node has a value that is equal to the sum of its descendants.

Input: root = [0]
Output: 1
For the node with value 0: The sum of its descendants is 0 since it has no descendants.
 

Constraints:

The number of nodes in the tree is in the range [1, 105].
0 <= Node.val <= 105
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
    int cnt;
    public int equalToDescendants(TreeNode root) {
        cnt = 0;
        getSum(root);
        return cnt;
    }
    
    private int getSum(TreeNode root) {
        if (root == null) return 0;
        int left = getSum(root.left);
        int right = getSum(root.right);
        
        if (root.val == (left + right)) {
            cnt++;
        }        
        return root.val + left + right;
    }
}
