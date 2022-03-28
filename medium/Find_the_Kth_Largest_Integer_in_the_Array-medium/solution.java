/*
You are given an array of strings nums and an integer k. Each string in nums represents an integer without leading zeros.

Return the string that represents the kth largest integer in nums.

Note: Duplicate numbers should be counted distinctly. 
For example, if nums is ["1","2","2"], "2" is the first largest integer, "2" is the second-largest integer, and "1" is the third-largest integer.

 

Example 1:

Input: nums = ["3","6","7","10"], k = 4
Output: "3"
Explanation:
The numbers in nums sorted in non-decreasing order are ["3","6","7","10"].
The 4th largest integer in nums is "3".
Example 2:

Input: nums = ["2","21","12","1"], k = 3
Output: "2"
Explanation:
The numbers in nums sorted in non-decreasing order are ["1","2","12","21"].
The 3rd largest integer in nums is "2".
Example 3:

Input: nums = ["0","0"], k = 2
Output: "0"
Explanation:
The numbers in nums sorted in non-decreasing order are ["0","0"].
The 2nd largest integer in nums is "0".
 

Constraints:

1 <= k <= nums.length <= 104
1 <= nums[i].length <= 100
nums[i] consists of only digits.
nums[i] will not have any leading zeros.
*/

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        List<Integer> keys = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            String s = nums[i];
            int n = s.length();
            if (map.containsKey(n)) {
                map.get(n).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(n, list);
                keys.add(n);
            }
        }
        Collections.sort(keys);
        int size = keys.size();
        String res = null;
        for (int i = size -1; i >=0; i--) {
            int key = keys.get(i);
            List<String> list = map.get(key);
            if (list.size() < k) {
                k -= list.size();
            } else {
                Collections.sort(list);
                res = list.get(list.size()-k);
                break;
            }
        }
        return res;
    }
}
