/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int n = nums.length;
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        };
        Arrays.sort(arr, com);
        if(arr[0].equals("0")) return "0"; //corner case.
        StringBuilder res = new StringBuilder();
        for(String s: arr) {
            res.append(s);
        }
        return res.toString();
    }
}
