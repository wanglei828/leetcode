/*
Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.

Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.

In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.

Example 1:

Input:
root = [1, 3, 2], k = 1
Diagram of binary tree:
          1
         / \
        3   2

Output: 2 (or 3)

Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
Example 2:

Input:
root = [1], k = 1
Output: 1

Explanation: The nearest leaf node is the root node itself.
Example 3:

Input:
root = [1,2,3,4,null,null,null,5,null,6], k = 2
Diagram of binary tree:
             1
            / \
           2   3
          /
         4
        /
       5
      /
     6

Output: 3
Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.

Note:
root represents a binary tree with at least 1 node and at most 1000 nodes.
Every node has a unique node.val in range [1, 1000].
There exists some node in the given binary tree for which node.val == k.
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
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        convertGraph(map, root, null);
        Queue<TreeNode> q = new LinkedList<>();
        for(TreeNode node: map.keySet()) {
            if(node != null && node.val == k) {
                q.add(node);
                break;
            }
        }
        Set<TreeNode> visit = new HashSet<>();
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(!visit.contains(cur)) {
                visit.add(cur);
                List<TreeNode> neighbor = map.get(cur);
                if(neighbor.size() == 1) {
                    return cur.val;
                } else {
                    for(TreeNode node: neighbor) {
                        if(!visit.contains(node) && node !=null ) {
                            q.add(node);
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    private void convertGraph(Map<TreeNode, List<TreeNode>> map, TreeNode cur, TreeNode parent) {
        if(cur == null) return;
        if(!map.containsKey(cur)) {
            map.put(cur, new ArrayList<TreeNode>());
        }
        if(!map.containsKey(parent)) {
            map.put(parent, new ArrayList<TreeNode>());
        }
        map.get(cur).add(parent);
        map.get(parent).add(cur);
        convertGraph(map, cur.left, cur);
        convertGraph(map, cur.right, cur);
    }
}
