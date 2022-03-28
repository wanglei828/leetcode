/*

Given a string s and a list of strings dict, 
you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. 
If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. 
Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
Example 1:
Input: 
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"
Example 2:
Input: 
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"
Note:
The given dict won't contain duplicates, and its length won't exceed 100.
All the strings in input have length in range [1, 1000].

*/

class Solution {
    public String addBoldTag(String s, String[] dict) {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            int start = i;
            int max = 0;
            for(String word: dict) {
                int end = start + word.length();
                if(end <= s.length() && s.substring(start, end).equals(word)) {
                    max = Math.max(max, end);
                }
            }
            if(max != 0) {
                list.add(new int[]{start, max});
            }
        }
        List<int[]> fList = new ArrayList<>();
        int[] pre = null;
        for(int i=0; i<list.size(); i++) {
            int[] cur = list.get(i);
            if(i == 0) {
                pre = cur;
                continue;
            }
            if(pre[1] >= cur[0]) {
                cur[0] = pre[0];
                cur[1] = Math.max(pre[1], cur[1]);
            } else {
                fList.add(pre);
            }
            pre = cur;
        }
        if(pre != null) {
            fList.add(pre);
        }
        StringBuilder sb = new StringBuilder();
        int before = 0;
        for(int[] cur: fList) {
            int start = cur[0];
            int end = cur[1];
            sb.append(s.substring(before, start));
            sb.append("<b>");
            sb.append(s.substring(start, end));
            sb.append("</b>");
            before = end;
        }
        sb.append(s.substring(before, s.length()));
        return sb.toString();
    }
}
