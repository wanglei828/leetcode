/*
Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.
*/

class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node() {};
        public Node(int _k, int _v) {
            key = _k;
            val = _v;
        }
    }
    
    int cap;
    Map<Integer, Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node res;
        if (map.containsKey(key)) {
            res = map.get(key);
            delete(res);
            add(res);
            return res.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            delete(cur);
            add(cur);
        } else {
            Node cur = new Node(key, value);
            if (map.size() < cap) {                               
                add(cur);
            } else {
                Node last = tail.prev;
                map.remove(last.key);
                delete(last);
                add(cur);
            }
            map.put(key, cur);
        }
    }
    
    private void delete(Node cur) {
        Node prev = cur.prev;
        Node next = cur.next;
        prev.next = next;
        next.prev = prev;
    }
    
    private void add(Node cur) {
        Node next = head.next;
        head.next = cur;
        cur.prev = head;
        cur.next = next;
        next.prev = cur;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
