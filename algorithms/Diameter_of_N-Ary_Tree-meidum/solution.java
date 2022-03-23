/*
Given a root of an N-ary tree, you need to compute the length of the diameter of the tree.

The diameter of an N-ary tree is the length of the longest path between any two nodes in the tree. This path may or may not pass through the root.

(Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value.)

Constraints:

The depth of the n-ary tree is less than or equal to 1000.
The total number of nodes is between [1, 104].
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int res;
    public int diameter(Node root) {
        res = 0;
        getDepth(root);
        return res;
    }
    
    private int getDepth(Node root) {
        if (root == null) return 0;
        int max1 = 0, max2 = 0;
        for (Node node : root.children) {
            int dep = getDepth(node);
            if (dep >= max1 && max1 >= max2) {
                max2 = max1;
                max1 = dep;
            } else if (dep >= max2) {
                max2 = dep;
            }
        }
        res = Math.max(res, max1 + max2);
        return max1 + 1;
    }
}
