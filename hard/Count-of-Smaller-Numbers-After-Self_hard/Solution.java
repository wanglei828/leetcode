/*
You are given an integer array nums and you have to return a new counts array. 
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
Return the array [2, 1, 1, 0].
*/

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) return res;
        List<Integer> v = new ArrayList<Integer>();
        for(int i=nums.length-1; i>=0; i--) {
            int tmp = nums[i];
            if(v.isEmpty()) {
                v.add(tmp);
                res.add(0);
            } else {
                int h = 0;
                int t = v.size()-1;
                while(h<=t) {
                    int m = h+(t-h)/2;
                    if(v.get(m) >= tmp) {
                        t = m-1;
                    } else {
                        h = m+1;
                    }
                }
                v.add(h, tmp);
                res.add(0, h);
            }
        }
        return res;
    }
}
