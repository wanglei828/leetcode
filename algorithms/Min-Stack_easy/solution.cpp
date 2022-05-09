class MinStack {
    stack<int> s;
    stack<int> mins;
public:
    MinStack() {
        
    }
    
    void push(int val) {
        if (s.empty()) {
            s.push(val);
            mins.push(val);
        } else {
            if (mins.top() < val) {
                mins.push(mins.top());
                s.push(val);
            } else {
                mins.push(val);
                s.push(val);
            }
        }
    }
    
    void pop() {
        s.pop();
        mins.pop();
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return mins.top();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
