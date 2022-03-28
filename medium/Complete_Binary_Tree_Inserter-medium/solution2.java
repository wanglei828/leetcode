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
    LinkedList<TreeNode> pending;
    TreeNode Root;
    public CBTInserter(TreeNode root) {
        Root = root;
        pending = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left == null || cur.right == null) {
                pending.addLast(cur);
            }
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
        TreeNode parent = pending.getFirst();
        pending.addLast(node);
        if (parent.left == null) {
            parent.left = node;
            return parent.val;
        }
        if (parent.right == null) {
            parent.right = node;
            pending.removeFirst();
        }
        return parent.val;
    }
    
    public TreeNode get_root() {
        return Root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */
