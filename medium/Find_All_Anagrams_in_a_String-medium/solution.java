/*

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if(s.length() < p.length()) return res;
        int[] pat = new int[26];
        int[] str = new int[26];
        for(int i=0; i<p.length(); i++) {
            char c1 = p.charAt(i);
            pat[c1-'a']++;
            char c2 = s.charAt(i);
            str[c2-'a']++;
        }
        int i=0, j=p.length()-1;
        while(j<s.length()) {
            if(isAna(pat, str)) {
                res.add(i);
            }
            str[s.charAt(i)-'a']--;
            i++;
            j++;
            if(j<s.length()) {
                str[s.charAt(j)-'a']++;
            }
        }
        return res;
    }
    
    private boolean isAna(int[] pat, int[] str) {
        for(int i=0; i<26; i++) {
            if(pat[i] != str[i]) {
                return false;
            }
        }
        return true;
    }
}
