/*
Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
*/

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0) {
            String s = printRange(lower, upper);
            res.add(s);
            return res;
        }
        int n = nums.length;
        if(nums[0] != lower) {
            res.add(printRange(lower, nums[0]-1));
        }
        for(int i=0; i<n-1; i++) {
            if(nums[i+1]-nums[i] >= 2) {
                res.add(printRange(nums[i]+1, nums[i+1]-1));
            }
        }
        if(nums[n-1] != upper) {
            res.add(printRange(nums[n-1]+1, upper));
        }
        return res;
    }
    
    private String printRange(int h, int t) {
        if(h == t) return String.valueOf(h);
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(h));
        sb.append("->");
        sb.append(String.valueOf(t));
        return sb.toString();
    }
}
