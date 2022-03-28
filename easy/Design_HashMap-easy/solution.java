/*

Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.

Example:

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);          // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);          // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 

Note:

All keys and values will be in the range of [0, 1000000].
The number of operations will be in the range of [1, 10000].
Please do not use the built-in HashMap library.

*/

class MyHashMap {
    int cap;
    List<List<int[]>> map;
    /** Initialize your data structure here. */
    public MyHashMap() {
        cap = 2069;
        map  = new ArrayList<List<int[]>>();
        for(int i=0; i<cap; i++) {
            map.add(new ArrayList<int[]>());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key%cap;
        List<int[]> cur = map.get(index);
        boolean find = false;
        for(int i=0; i<cur.size(); i++) {
            if(cur.get(i)[0] == key) {
                cur.get(i)[1] = value;
                find = true;
                break;
            }
        }
        if(!find) {
            cur.add(new int[]{key, value});
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key%cap;
        List<int[]> cur = map.get(index);
        for(int i=0; i<cur.size(); i++) {
            if(cur.get(i)[0] == key) {
                return cur.get(i)[1];
            }
        }
        return -1;      
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key%cap;
        List<int[]> cur = map.get(index);
        for(int i=0; i<cur.size(); i++) {
            if(cur.get(i)[0] == key) {
                cur.remove(i);
            }
        }        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
