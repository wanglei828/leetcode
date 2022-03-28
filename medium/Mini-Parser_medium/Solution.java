/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
 
public class Solution {
    public NestedInteger deserialize(String s) {
        if(s == null || s.length() == 0) return null;
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        int n = s.length(), sign = 1;
        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            if(c == '[') {
                stack.push(new NestedInteger());
            } else if(c == '-') {
                sign = -1;
            } else if(c == ']' && stack.size() > 1) {
                NestedInteger cur = stack.pop();
                stack.peek().add(cur);
            } else if(c >= '0' && c <= '9') {
                int e = i;
                while(e< n && s.charAt(e) >= '0' && s.charAt(e) <= '9') e++;
                int num = Integer.valueOf(s.substring(i, e));
                num *= sign;
                if(stack.isEmpty()) {
                    return new NestedInteger(num);
                } else {
                    stack.peek().add(new NestedInteger(num));
                }
                sign = 1;
                i = e-1;
            }
        }
        return (stack.isEmpty())? new NestedInteger(): stack.pop();
    }
}
