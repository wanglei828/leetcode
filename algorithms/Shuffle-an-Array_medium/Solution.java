/*
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. 
Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
*/

import java.util.Random;
public class Solution {
    
    int[] nums;
    Random ran;
    public Solution(int[] nums) {
        if(nums == null || nums.length == 0) return;
        this.nums = nums.clone();
        ran = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return (nums == null)? new int[0]: nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null || nums.length == 0) return new int[0];
        int[] res = nums.clone();
        for(int i=1; i<res.length; i++) {
            int j = ran.nextInt(i+1);
            swap(res, i, j);
        }
        return res;
    }
    
    private void swap(int[] res, int i, int j) {
        int tmp = res[i];
        res[i] = res[j];
        res[j] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
