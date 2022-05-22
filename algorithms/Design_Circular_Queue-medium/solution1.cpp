class MyCircularQueue {
private:
    int* arr;
    int cnt;
    int head;
    int cap;
public:
    MyCircularQueue(int k) {
        arr = new int[k];
        cnt = 0;
        head = 0;
        cap = k;
    }
    
    bool enQueue(int value) {
        if (cnt == cap) return false;
        int end = (head + cnt) % cap;
        arr[end] = value;
        cnt++;
        return true;
    }
    
    bool deQueue() {
        if (cnt == 0) return false;
        head = (head + 1) % cap;
        cnt--;
        return true;
    }
    
    int Front() {
        if (cnt == 0) return -1;
        return arr[head];
    }
    
    int Rear() {
        if (cnt == 0) return -1;
        int end = (head + cnt - 1) % cap;
        return arr[end];
    }
    
    bool isEmpty() {
        return cnt == 0;
    }
    
    bool isFull() {
        return cnt == cap;
    }
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue* obj = new MyCircularQueue(k);
 * bool param_1 = obj->enQueue(value);
 * bool param_2 = obj->deQueue();
 * int param_3 = obj->Front();
 * int param_4 = obj->Rear();
 * bool param_5 = obj->isEmpty();
 * bool param_6 = obj->isFull();
 */
