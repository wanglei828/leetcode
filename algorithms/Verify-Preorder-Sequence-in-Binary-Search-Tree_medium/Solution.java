/*
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?
*/

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) return true;
        Stack<Integer> s = new Stack<Integer>();
        int curMin = Integer.MIN_VALUE;
        for(int val: preorder) {
            if(val < curMin) {
                return false;
            }
            while(!s.isEmpty() && val > s.peek()) {
                curMin = s.pop();
            }
            s.push(val);
        }
        return true;
    }
}
