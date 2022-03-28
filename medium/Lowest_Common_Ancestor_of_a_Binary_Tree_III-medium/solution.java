/*
Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).

Each node will have a reference to its parent node. The definition for Node is below:

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}
According to the definition of LCA on Wikipedia: 
"The lowest common ancestor of two nodes p and q in a tree T is the lowest node that has both p and q as descendants (
where we allow a node to be a descendant of itself)."

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q exist in the tree.
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
    public Node lowestCommonAncestor(Node p, Node q) {
        Node res = null;
        if (find(p, q)) {
            res = p;
        } else {
            Node node = p;
            Node par = node.parent;
            while (par != null) {
                if (par == q) {
                    res = q;
                    break;
                }
                if (par.left == node && find(par.right, q)) {
                    res = par;
                    break;
                }
                if (par.right == node && find(par.left, q)) {
                    res = par;
                    break;
                }
                node = par;
                par = par.parent;
            }
        }
        return res;
    }
    
    private boolean find(Node root, Node tar) {
        if (root == null) return false;
        if (root == tar) return true;
        if (find(root.left, tar)) {
            return true;
        } 
        if (find(root.right, tar)) {
            return true;
        }        
        return false;
    }
}

