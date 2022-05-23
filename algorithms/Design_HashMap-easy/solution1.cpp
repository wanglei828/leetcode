class MyHashMap {
    vector<list<pair<int, int>>> map;
    int cap;
public:
    MyHashMap() {
        cap = 2069;
        map.resize(2069);
    }
    
    void put(int key, int value) {
        int index = key % cap;
        list<pair<int, int>>& cur = map[index];
        for (auto& p: cur) {
            if (p.first == key) {
                p.second = value;
                return;
            }
        }
        cur.push_back({key, value});
    }
    
    int get(int key) {
        int index = key % cap;
        list<pair<int, int>>& cur = map[index];
        for (auto& p: cur) {
            if (p.first == key) {
                return p.second;
            }
        }
        return -1;
    }
    
    void remove(int key) {
        int index = key % cap;
        list<pair<int, int>>& cur = map[index];
        for (auto& p: cur) {
            if (p.first == key) {
                cur.remove(p);
                break;
            }
        }        
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
