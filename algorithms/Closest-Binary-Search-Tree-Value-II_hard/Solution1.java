/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> suc = new Stack<TreeNode>();
        Stack<TreeNode> pre = new Stack<TreeNode>();
        initSuc(suc, root, target);
        initPre(pre, root, target);
        if(!suc.isEmpty() && !pre.isEmpty() && suc.peek().val == pre.peek().val) {
            res.add(suc.peek().val);
            getNextSuc(suc);
            getNextPre(pre);
            k--;
        }
        while(k>0) {
            if(suc.isEmpty() && !pre.isEmpty()) {
                res.add(pre.peek().val);
                getNextPre(pre);
            } else if(pre.isEmpty() && !suc.isEmpty()) {
                res.add(suc.peek().val);
                getNextSuc(suc);
            } else if(!pre.isEmpty() && !suc.isEmpty()) {
                if(target - pre.peek().val < suc.peek().val - target) {
                    res.add(pre.peek().val);
                    getNextPre(pre);
                } else {
                    res.add(suc.peek().val);
                    getNextSuc(suc);
                }
            } else {
                break;
            }
            k--;
        }
        return res;
    }
    
    private void initSuc(Stack<TreeNode> s, TreeNode root, double target) {
        while(root != null) {
            if(root.val == target) {
                s.push(root);
                break;
            } else if (root.val < target) {
                root = root.right;
            } else {
                s.push(root);
                root = root.left;
            }
        }
    }
    
    private void initPre(Stack<TreeNode> s, TreeNode root, double target) {
        while(root != null) {
            if(root.val == target) {
                s.push(root);
                break;
            } else if (root.val < target) {
                s.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
    
    private void getNextSuc(Stack<TreeNode> suc) {
        TreeNode top = suc.pop();
        top = top.right;
        while(top != null) {
            suc.push(top);
            top = top.left;
        }
    }
    
    private void getNextPre(Stack<TreeNode> pre) {
        TreeNode top = pre.pop();
        top = top.left;
        while(top != null) {
            pre.push(top);
            top = top.right;
        }
    }
}
