class Node {
public:
    int key;
    int val;
    Node * prev;
    Node * next;
    Node () {};
    Node (int _k, int _v) {
        key = _k;
        val = _v;
        prev = NULL;
        next = NULL;
    }
};
class LRUCache {
    Node head;
    Node tail;
    int cap;
    unordered_map<int, Node*> map;
public:
    LRUCache(int capacity) {
        cap = capacity;
        head.next = &tail;
        tail.prev = &head;
    }
    void add(Node* n) {
        Node * next = head.next;
        head.next = n;
        n->prev = &head;
        n->next = next;
        next->prev = n;
    }
    
    void remove(Node* n) {
        Node* prev = n->prev;
        Node* next = n->next;
        prev->next = next;
        next->prev = prev;
    }
    
    int get(int key) {
        int res = -1;
        if (map.find(key) != map.end()) {
            Node* n = map[key];
            res = n->val;
            remove(n);
            add(n);
        }
        return res;
    }
    
    void put(int key, int value) {
        if (map.find(key) != map.end()) {
            Node* n = map[key];
            n->val = value;
            remove(n);
            add(n);
        } else {
            Node* n = new Node(key, value);
            if (map.size() < cap) {
                add(n);
            } else {
                Node* last = tail.prev;
                map.erase(last->key);
                remove(last);
                add(n);
            }
            map[key] = n;
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
