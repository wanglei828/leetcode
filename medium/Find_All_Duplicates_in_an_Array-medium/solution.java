/*

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), 
some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] == i+1) continue;
            int t = i;
            while(nums[t] != t+1) {
                if(nums[t] == 0) break;
                int tmp = nums[nums[t]-1];
                if(tmp == nums[t]) {
                    res.add(tmp);
                    nums[t] = 0;
                    break;
                } else {
                    nums[nums[t]-1] = nums[t];
                    nums[t] = tmp;
                }
      
            }
        }
        return res;
    }
}
