/*
You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. 
You are also given an integer startValue representing the value of the start node s, 
and a different integer destValue representing the value of the destination node t.

Find the shortest path starting from node s and ending at node t. 
Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. 
Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.

Constraints:

The number of nodes in the tree is n.
2 <= n <= 105
1 <= Node.val <= n
All the values in the tree are unique.
1 <= startValue, destValue <= n
startValue != destValue
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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        LinkedList<Character> startList = new LinkedList<>();
        LinkedList<Character> destList = new LinkedList<>();
        findPath(root, startValue, startList);
        findPath(root, destValue, destList);
        while (!startList.isEmpty() && !destList.isEmpty() && startList.getFirst() == destList.getFirst()) {
            startList.removeFirst();
            destList.removeFirst();
        }
        StringBuilder sb = new StringBuilder();
        while(!startList.isEmpty()) {
            sb.append('U');
            startList.removeFirst();
        }
        while(!destList.isEmpty()) {
            sb.append(destList.getFirst());
            destList.removeFirst();
        }
        return sb.toString();
    }
    
    private boolean findPath(TreeNode node, int value, LinkedList<Character> list) {
        if (node.val == value) {
            return true;
        }        
        if (node.right != null) {
            list.addLast('R');
            if (findPath(node.right, value, list)) {
                return true;
            } else {
                list.removeLast();
            }
        }  
        if (node.left != null) {
            list.addLast('L');
            if (findPath(node.left, value, list)) {
                return true;
            } else {
                list.removeLast();
            }
        }
        return false;
    }
}
