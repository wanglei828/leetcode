/*
A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, 
and all nodes are as far left as possible.

Design an algorithm to insert a new node to a complete binary tree keeping it complete after the insertion.

Implement the CBTInserter class:

CBTInserter(TreeNode root) Initializes the data structure with the root of the complete binary tree.
int insert(int v) Inserts a TreeNode into the tree with value Node.val == val so that the tree remains complete, 
and returns the value of the parent of the inserted TreeNode.
TreeNode get_root() Returns the root node of the tree.
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
class CBTInserter {
    List<TreeNode> nodeList;
    public CBTInserter(TreeNode root) {
        nodeList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            nodeList.add(cur);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }
    
    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        nodeList.add(node);
        int n = nodeList.size() - 1;
        TreeNode parent = null;
        if (n % 2 == 0) {
            int index = n/2 -1;
            parent = nodeList.get(index);
            parent.right = node;
        } else {
            int index = n/2;
            parent = nodeList.get(index);
            parent.left = node;

        }
        return parent.val;
    }
    
    public TreeNode get_root() {
        return nodeList.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
