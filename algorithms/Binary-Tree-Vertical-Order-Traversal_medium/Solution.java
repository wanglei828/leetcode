/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
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
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<TreeNode> nQ = new LinkedList<TreeNode>();
        Queue<Integer> tagQ = new LinkedList<Integer>();
        nQ.add(root);
        tagQ.add(0);
        while(!nQ.isEmpty()) {
            TreeNode node = nQ.poll();
            int tag = tagQ.poll();
            if(map.containsKey(tag)) {
                map.get(tag).add(node.val);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(node.val);
                map.put(tag, list);
            }
            if(node.left != null) {
                nQ.add(node.left);
                tagQ.add(tag-1);
            }
            if(node.right != null) {
                nQ.add(node.right);
                tagQ.add(tag+1);
            }
        }
        int[] arr = new int[map.size()];
        int i=0;
        for(Integer key:map.keySet()) {
            arr[i] = key;
            i++;
        }
        Arrays.sort(arr);
        for(i=0; i<arr.length; i++) {
            res.add(map.get(arr[i]));
        }
        return res;
    }
}
