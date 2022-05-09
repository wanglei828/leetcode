class MyQueue {
    stack<int> s;
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        if (s.empty()) {
            s.push(x);
        } else {
            stack<int> tmp;
            while (!s.empty()) {
                int cur = s.top();
                s.pop();
                tmp.push(cur);
            }
            s.push(x);
            while (!tmp.empty()) {
                int cur = tmp.top();
                tmp.pop();
                s.push(cur);
            }
        }
    }
    
    int pop() {
        int cur = s.top();
        s.pop();
        return cur;
    }
    
    int peek() {
        return s.top();
    }
    
    bool empty() {
        return s.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
