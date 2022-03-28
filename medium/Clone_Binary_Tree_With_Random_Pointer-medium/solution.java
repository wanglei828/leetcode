/*
A binary tree is given such that each node contains an additional random pointer which could point to any node in the tree or null.

Return a deep copy of the tree.

The tree is represented in the same input/output way as normal binary trees where each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (in the input) where the random pointer points to, or null if it does not point to any node.
You will be given the tree in class Node and you should return the cloned tree in class NodeCopy. 
NodeCopy class is just a clone of Node class with the same attributes and constructors.

Constraints:

The number of nodes in the tree is in the range [0, 1000].
1 <= Node.val <= 106
*/

/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class Solution {
    HashMap<Node, NodeCopy> map;
    public NodeCopy copyRandomBinaryTree(Node root) {
        if (root == null) return null;
        map = new HashMap<>();
        traverse(root);
        return map.get(root);
    }
    
    private void traverse(Node root) {
        if (root == null) return;
        NodeCopy copyRoot = null;
        if (map.containsKey(root)) {
            copyRoot = map.get(root);
        } else {
            copyRoot = new NodeCopy(root.val);
            map.put(root, copyRoot);
        }
        if (root.left != null) {
            NodeCopy copyLeft = null;
            if(map.containsKey(root.left)) {
                copyLeft = map.get(root.left);
            } else {
                copyLeft = new NodeCopy(root.left.val);
                map.put(root.left, copyLeft);
            }
            copyRoot.left = copyLeft;
            traverse(root.left);
        }
        if (root.right != null) {
            NodeCopy copyRight = null;
            if(map.containsKey(root.right)) {
                copyRight = map.get(root.right);
            } else {
                copyRight = new NodeCopy(root.right.val);
                map.put(root.right, copyRight);
            }
            copyRoot.right = copyRight;
            traverse(root.right);
        }
        if (root.random != null) {
            NodeCopy copyRandom = null;
            if(map.containsKey(root.random)) {
                copyRandom = map.get(root.random);
            } else {
                copyRandom = new NodeCopy(root.random.val);
                map.put(root.random, copyRandom);
            }
            copyRoot.random = copyRandom;
        }
    }
}
