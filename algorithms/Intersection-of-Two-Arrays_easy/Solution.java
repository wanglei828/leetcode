/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums1) {
            set.add(i);
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i : nums2) {
            if(set.contains(i)) {
                res.add(i);
                set.remove(i);
            }
        }
        int[] result = new int[res.size()];
        for(int i=0; i<res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
