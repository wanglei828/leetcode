/*
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
*/

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums.length == 0) return res;
        int h = nums[0];
        int t = nums[0];
        for(int i = 1; i<nums.length;i++) {
            if((nums[i]-nums[i-1])==1) {
                t = nums[i];
            } else {
                res.add(output(h,t));
                h = nums[i];
                t = nums[i];
            }
        }
        res.add(output(h,t));
        return res;
    }
    private String output(int h, int t) {
        if(h==t) return Integer.toString(h);
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(h));
        sb.append("->");
        sb.append(Integer.toString(t));
        return sb.toString();
    }
}
