/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return helper(nestedList, 0);
    }
    
    private int helper(List<NestedInteger> nestedList, int prev) {
        List<NestedInteger> next = new ArrayList<NestedInteger>();
        for(NestedInteger i : nestedList) {
            if(i.isInteger()) {
                prev += i.getInteger();
            } else {
                next.addAll(i.getList());
            }
        }
        int nextsum = (next.isEmpty())? 0 : helper(next, prev);
        return nextsum + prev;
    }
}
