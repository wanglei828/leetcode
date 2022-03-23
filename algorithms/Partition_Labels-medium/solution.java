/*
You are given a string s. 
We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

 

Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Example 2:

Input: s = "eccbbbbdec"
Output: [10]
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
*/

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] index = new int[26];
        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            index[c - 'a'] = i;
        }
        while (start < s.length()) {
            for(int i = start; i <= end; i++) {
                char c = s.charAt(i);
                end = Math.max(end, index[c - 'a']);
            }
            res.add(end - start + 1);
            end++;
            start = end;
        }
        return res;
    }
}
