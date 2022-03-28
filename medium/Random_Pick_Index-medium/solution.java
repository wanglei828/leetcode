/*

Given an array of integers with possible duplicates, 
randomly output the index of a given target number. 
You can assume that the given target number must exist in the array.

Note:
The array size can be very large. Solution that uses too much extra space will not pass the judge.

Example:

int[] nums = new int[] {1,2,3,3,3};
Solution solution = new Solution(nums);

// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
solution.pick(3);

// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
solution.pick(1);

*/

class Solution {
    Map<Integer, List<Integer>> map;
    Random random;
    public Solution(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        if(nums == null || nums.length == 0) return;
        for(int i=0; i<nums.length; i++) {
            int cur = nums[i];
            if(!map.containsKey(cur)) {
                map.put(cur, new ArrayList<Integer>());
            }
            map.get(cur).add(i);
        }
    }
    
    public int pick(int target) {
        if(map.containsKey(target)) {
            List<Integer> list = map.get(target);
            return list.get(random.nextInt(list.size()));
        } else {
            return -1;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
