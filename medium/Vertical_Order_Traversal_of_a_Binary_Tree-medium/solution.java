/*

Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

 

Example 1:
Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).

Example 2:

Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: 
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 

Note:

The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.

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
class Location {
    int x, y, val;
    Location(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

class Solution {
    List<Location> allNode = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root, null);
        Collections.sort(allNode, new Comparator<Location>(){
            @Override 
            public int compare(Location l1, Location l2) {
                if(l1.x != l2.x) {
                    return l1.x - l2.x;
                } else if (l1.y != l2.y) {
                    return l2.y - l1.y;
                } else {
                    return l1.val - l2.val;
                }
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        int preX = allNode.get(0).x;
        for(int i=0; i<allNode.size(); i++) {
            Location cur = allNode.get(i);
            if(cur.x == preX) {
                if(res.isEmpty()) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur.val);
                    res.add(list);
                } else {
                    res.get(res.size()-1).add(cur.val);
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(cur.val);
                res.add(list);
                preX = cur.x;
            }
        }
        return res;
    }
    
    private void traverse(TreeNode root, Location loc) {
        if(root == null) return;
        if(loc == null) {
            loc = new Location(0, 0, root.val);
            allNode.add(loc);
        } else {
            loc.val = root.val;
            allNode.add(loc);
        }
        traverse(root.left, new Location(loc.x-1, loc.y-1, 0));
        traverse(root.right, new Location(loc.x+1, loc.y-1, 0));
    }
}
