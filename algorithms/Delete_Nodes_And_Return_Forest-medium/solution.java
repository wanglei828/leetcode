/*

Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, 
we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  
You may return the result in any order.

 

Example 1:
Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
 

Constraints:

The number of nodes in the given tree is at most 1000.
Each node has a distinct value between 1 and 1000.
to_delete.length <= 1000
to_delete contains distinct values between 1 and 1000.

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    List<TreeNode> deleteList = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int i: to_delete) {
            set.add(i);
        }
        convert(root, null);
        for(TreeNode cur: deleteList) {
            delete(cur);
        }
        List<TreeNode> res = new ArrayList<>();
        for(TreeNode cur: map.keySet()) {
            List<TreeNode> list = map.get(cur);
            if(list.get(0) == null) {
                res.add(cur);
            }
        }
        return res;
    }
    
    private void convert(TreeNode root, TreeNode parent) {
        if(root == null) return;
        if(set.contains(root.val)) {
            deleteList.add(root);
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(parent);
        list.add(root.left);
        list.add(root.right);
        map.put(root, list);
        convert(root.left, root);
        convert(root.right, root);
    }
    
    private void delete(TreeNode cur) {
        List<TreeNode> list = map.get(cur);
        TreeNode parent = list.get(0);
        TreeNode left = list.get(1);
        TreeNode right = list.get(2);
        if(parent != null) {
            if(parent.left == cur) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        if(left != null) {
            List<TreeNode> leftList = map.get(left);
            leftList.set(0, null);
        }
        if(right != null) {
            List<TreeNode> rightList = map.get(right);
            rightList.set(0, null);
        }
        map.remove(cur);
    }
}
