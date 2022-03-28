/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II
*/

public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k==0) return;
        int n = nums.length;
        k = k%n;
        int a = n - k;
        reverse(nums, 0, a-1);
        reverse(nums, a, n-1);
        reverse(nums, 0, n-1);
    }
    private void reverse(int[] nums, int s, int e) {
        while(s<e) {
            int tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
            s++;
            e--;
        }
    }
}
