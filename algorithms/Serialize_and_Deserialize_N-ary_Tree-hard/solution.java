/*

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, 
or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize an N-ary tree. 
An N-ary tree is a rooted tree in which each node has no more than N children. 
There is no restriction on how your serialization/deserialization algorithm should work. 
You just need to ensure that an N-ary tree can be serialized to a string 
and this string can be deserialized to the original tree structure.

Note:

N is in the range of [1, 1000]
Do not use class member/global/static variables to store states. 
Your serialize and deserialize algorithms should be stateless.

*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        List<Node> list = root.children;
        sb.append(",");
        sb.append(list.size());
        for(int i=0; i<list.size(); i++) {
            String cur = serialize(list.get(i));
            sb.append(",");
            sb.append(cur);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if("#".equals(data)) return null;
        String[] arr = data.split(",");
        Queue<String> q = new LinkedList<>();
        for(String str: arr) {
            q.add(str);
        }
        return visit(q);
    }
    
    private Node visit(Queue<String> q) {
        int val = Integer.valueOf(q.poll());
        int size = Integer.valueOf(q.poll());
        List<Node> list = new ArrayList<>();
        Node root = new Node(val, list);
        for(int i=0; i<size; i++) {
            list.add(visit(q));
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
