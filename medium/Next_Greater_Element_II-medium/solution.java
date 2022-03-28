/*

Given a circular array (the next element of the last element is the first element of the array), 
print the Next Greater Number for every element. 
The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, 
which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
Note: The length of given array won't exceed 10000.

*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[]{};
        if(nums.length < 2) return new int[]{-1};
        int n = nums.length;
        int[] index = new int[n];
        Arrays.fill(index, -1);
        for(int i=0; i<n; i++) {
            int start = i;
            if(i == 0) {
                start = i+1;
            } else {
                if (nums[i] > nums[i-1]) {
                    start = (index[i-1] + 1)%n;
                } else if (nums[i] == nums[i-1]) {
                    index[i] = index[i-1];
                    continue;
                } else {
                    start = (i+1)%n;
                }
            }
            while(start != i) {
                if(nums[start] > nums[i]) {
                    index[i] = start;
                    break;
                } else if( nums[start] == nums[i]) {
                    if(index[start] != -1) {
                        index[i] = index[start];
                        break;
                    } else {
                        start = (start+1)%n;
                    }
                } else {
                    if(index[start] != -1) {
                        start = index[start];
                    } else {
                        start = (start+1)%n;
                    }
                }
            }
        }
        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            if(index[i] != -1) {
                res[i] = nums[index[i]];
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}
