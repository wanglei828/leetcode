/*
You are given an array of strings words. Each element of words consists of two lowercase English letters.

Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. 
Each element can be selected at most once.

Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.

A palindrome is a string that reads the same forward and backward.

 

Example 1:

Input: words = ["lc","cl","gg"]
Output: 6
Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
Note that "clgglc" is another longest palindrome that can be created.
Example 2:

Input: words = ["ab","ty","yt","lc","cl","ab"]
Output: 8
Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
Note that "lcyttycl" is another longest palindrome that can be created.
Example 3:

Input: words = ["cc","ll","xx"]
Output: 2
Explanation: One longest palindrome is "cc", of length 2.
Note that "ll" is another longest palindrome that can be created, and so is "xx".
 

Constraints:

1 <= words.length <= 105
words[i].length == 2
words[i] consists of lowercase English letters.
*/

class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        unordered_map<string, int> map;
        for (string s : words) {
            if (map.find(s) != map.end()) {
                map[s]++;
            } else {
                map[s] = 1;
            }
        }
        int res = 0;
        bool found = false;
        for (int i = 0; i < words.size(); i++) {
            string s = words[i];
            if (map.find(s) == map.end()) {
                continue;
            }
            map[s]--;
            if (map[s] == 0) {
                map.erase(s);
            }
            string rs = "";
            rs.push_back(s[1]);
            rs.push_back(s[0]);
            if (map.find(rs) != map.end()) {
                res += 4;
                map[rs]--;
                if (map[rs] == 0) {
                    map.erase(rs);
                }
            } else if (s[0] == s[1] && !found) {
                res += 2;
                found = true;
            }
        }
        return res;
    }
};
