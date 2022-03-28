/*
Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.
*/

class Node {
    int key;
    int val;
    Node next;
    Node pre;
    public Node(int k, int v) {
        key = k;
        val =v;
    }
}
public class LRUCache {
    private int cap = 0;
    private Map<Integer, Node> map = null;
    private Node head = null;
    private Node end = null;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            if(head != node)  {
                remove(node);
                setHead(node);
            }
            return node.val;
        } else {
            return -1;
        }
    }
    
    private void setHead(Node node) {
        if(head == null) {
            head = node;
            end = node;
        } else {
            node.next = head;
            head.pre = node;
            node.pre = null;
            head = node;
        }
    }
    
    private void remove(Node node) {
        if(node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }
        if(node.next != null) {
            node.next.pre = node.pre;
        } else {
            end = node.pre;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            map.put(key, node);
            remove(node);
            setHead(node);
        } else {
            Node node = new Node(key, value);
            if(map.size() < cap) {
                map.put(key, node);
                setHead(node);
            } else {
                map.remove(end.key);
                map.put(key, node);
                remove(end);
                setHead(node);
            }
        }
    }
}
