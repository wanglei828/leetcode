/*
Given a string s and a string array dictionary, return the longest string in the dictionary 
that can be formed by deleting some of the given string characters. If there is more than one possible result, 
return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

 

Example 1:

Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
Output: "apple"
Example 2:

Input: s = "abpcplea", dictionary = ["a","b","c"]
Output: "a"
 

Constraints:

1 <= s.length <= 1000
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 1000
s and dictionary[i] consist of lowercase English letters.
*/

class Solution {
public:
    string findLongestWord(string s, vector<string>& dictionary) {
        map<int, vector<string>, greater<int>> map;
        for (string cur : dictionary) {
            int l = cur.length();
            if (map.find(l) == map.end()) {
                map[l] = vector<string>();
            }
            map[l].push_back(cur);
        }
        for (auto &p: map) {
            vector<string> & vec = p.second;
            sort(vec.begin(), vec.end());
            for (string &cur : vec) {
                if (check(s, cur)) {
                    return cur;
                }
            }
        }
        return "";
    }
    
    bool check(string s, string cur) {
        int i = 0, j = 0;
        while (i < s.length() & j < cur.length()) {
            if (s[i] == cur[j]) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == cur.length();
    }
};
