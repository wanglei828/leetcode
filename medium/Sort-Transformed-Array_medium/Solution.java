/*
Given a sorted array of integers nums and integer values a, b and c. 
Apply a function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example:
nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,

Result: [3, 9, 15, 33]

nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5

Result: [-23, -5, 1, 7]
*/

public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0) return new int[0];
        int n = nums.length;
        int[] res = new int[n];
        int index = (a>=0)? n-1 : 0;
        int h=0, t=n-1;
        while(h<=t) {
            if(a>=0) {
                res[index--] = (cal(nums[h], a, b, c) > cal(nums[t], a, b, c))? cal(nums[h++], a ,b ,c) : cal(nums[t--], a ,b, c);
            } else {
                res[index++] = (cal(nums[h], a, b, c) < cal(nums[t], a, b, c))? cal(nums[h++], a ,b ,c) : cal(nums[t--], a ,b, c);
            }
        }
        return res;
    }
    private int cal(int x, int a, int b, int c) {
        return a*x*x + b*x + c;
    }
}
