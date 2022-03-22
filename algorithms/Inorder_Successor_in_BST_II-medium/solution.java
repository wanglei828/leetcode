/*
Given a node in a binary search tree, return the in-order successor of that node in the BST. 
If that node has no in-order successor, return null.

The successor of a node is the node with the smallest key greater than node.val.

You will have direct access to the node but not to the root of the tree. 
Each node will have a reference to its parent node. Below is the definition for Node:

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        if (node == null) return null;
        if (node.right != null) {
            node = node.right;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        } else if (node.parent != null) {
            if (node.parent.left == node) {
                return node.parent;
            } else {
                while(node.parent != null && node.parent.right == node) {
                    node = node.parent;
                }
                return node.parent;
            }
        } else {
          return null;
        }
    }
}
