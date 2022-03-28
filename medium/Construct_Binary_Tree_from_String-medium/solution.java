/*
You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. 
The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it exists.

Input: s = "4(2(3)(1))(6(5))"
Output: [4,2,6,3,1,5]

Input: s = "-4(2(3)(1))(6(5)(7))"
Output: [-4,2,6,3,1,5,7]
 

Constraints:

0 <= s.length <= 3 * 104
s consists of digits, '(', ')', and '-' only.
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
    int index;
    public TreeNode str2tree(String s) {
        index = 0;
        return buildTree(s);
    }
    
    private TreeNode buildTree(String s) {
        if (index == s.length()) return null;
        int sign = 1;
        if (s.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        int start = index;
        while(index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            index++;
        }
        int value = sign * Integer.valueOf(s.substring(start, index));
        TreeNode root = new TreeNode(value);
        
        if (index < s.length() && s.charAt(index) == '(') {
            if (root.left == null) {
                index++;
                root.left = buildTree(s);
            }
            if (index < s.length() && s.charAt(index) == '(') {
                index++;
                root.right = buildTree(s);
            }
        }
        index++;
        return root;
    }
}
