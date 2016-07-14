/*
Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary tree can be serialized to a string 
and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. 
You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if(sb.length() != 0) {
                sb.append(",");
            }
            if(tmp == null) {
                sb.append("null");
            } else {
                sb.append(String.valueOf(tmp.val));
                q.add(tmp.left);
                q.add(tmp.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] strArr = data.split(",");
        int n = strArr.length;
        TreeNode root = null;
        Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
        int nulls = 0;
        for(int i=0; i<n; i++) {
            String s = strArr[i];
            if(s.equals("null")) {
                nulls++;
            } else {
                TreeNode node = null;
                if(map.containsKey(i)) {
                    node = map.get(i);
                } else {
                    node = buildNode(s);
                    map.put(i, node);
                }
                TreeNode left = buildNode(strArr[2*(i-nulls)+1]);
                TreeNode right = buildNode(strArr[2*(i-nulls)+2]);
                node.left = left;
                node.right = right;
                if(left != null) {
                    map.put(2*(i-nulls)+1, left);
                }
                if(right != null) {
                    map.put(2*(i-nulls)+2, right);
                }
                if(root == null) {
                    root = node;
                }
            }
        }
        return root;
    }
    
    private TreeNode buildNode(String s) {
        if(s.equals("null")) return null;
        TreeNode node = null;
        node = new TreeNode(Integer.parseInt(s));
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
