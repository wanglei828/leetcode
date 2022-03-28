/*

Serialization is the process of converting a data structure or object into a sequence of bits 
so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that a binary search tree can be serialized to a string and 
this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. 
Your serialize and deserialize algorithms should be stateless.

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
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if(sb.length() != 0) {
                sb.append(",");
            }
            if(tmp != null) {
                sb.append(tmp.val);
                q.add(tmp.left);
                q.add(tmp.right);
            } else {
                sb.append("null");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String[] strArr = data.split(",");
        Map<Integer, TreeNode> map = new HashMap<>();
        int nulls = 0;
        for(int i=0; i<strArr.length; i++) {
            String str = strArr[i];
            if("null".equals(str)) {
                nulls++;
            } else {
                TreeNode cur = null;
                if(map.containsKey(i)) {
                    cur = map.get(i);
                } else {
                    cur = BuildNode(str);
                    map.put(i, cur);
                }
                TreeNode left = BuildNode(strArr[2*(i-nulls)+1]);
                TreeNode right = BuildNode(strArr[2*(i-nulls)+2]);
                cur.left = left;
                cur.right = right;
                if(left != null) {
                    map.put(2*(i-nulls)+1, left);
                }
                if(right != null) {
                    map.put(2*(i-nulls)+2, right);
                }
            }
        }
        return map.get(0);
    }
    
    private TreeNode BuildNode(String str) {
        if(str.equals("null")) return null;
        return new TreeNode(Integer.parseInt(str));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
