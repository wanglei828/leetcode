/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/

public class NumArray {
    private Map<Integer, Integer> sumMap;
    private int length;
    public NumArray(int[] nums) {
        sumMap = new HashMap<Integer, Integer>();
        length = nums.length;
        sumMap.put(-1, 0);
        int sum = 0;
        for(int i= 0; i < nums.length; i++){
            sum += nums[i];
            sumMap.put(i, sum);
        }
    }

    public int sumRange(int i, int j) {
        if ( i < 0) i = 0;
        if ( j >= length) j = length-1;
        return sumMap.get(j) - sumMap.get(i-1); 
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
