/*

We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.

Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.
 

Note:

The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.

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
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        List<Integer> res = new ArrayList<Integer>();
        convertGraph(map, root, null);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.add(target);
        visited.add(target);
        while(!q.isEmpty()) {
            if(K == 0) {
                while(!q.isEmpty()) {
                    res.add(q.poll().val);
                }
                break;
            }
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode cur = q.poll();
                for(TreeNode node:map.get(cur)) {
                    if(!visited.contains(node) && node != null) {
                        q.add(node);
                        visited.add(node);
                    }
                }
            }
            K--;
        }
        return res;
    }
    
    private void convertGraph(Map<TreeNode, List<TreeNode>> map, TreeNode cur, TreeNode parent) {
        if(!map.containsKey(cur)) {
            map.put(cur, new ArrayList<TreeNode>());
        }
        map.get(cur).add(parent);
        if(!map.containsKey(parent)) {
            map.put(parent , new ArrayList<TreeNode>());
        }
        map.get(parent).add(cur);
        if(cur.left != null) convertGraph(map, cur.left, cur);
        if(cur.right != null) convertGraph(map, cur.right, cur);
    }

}
