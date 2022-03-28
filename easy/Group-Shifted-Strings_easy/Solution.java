/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". 
We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
A solution is:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
*/

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strings == null || strings.length == 0) return res;
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i=0; i<strings.length; i++) {
            String s = strings[i];
            String key = getKey(s);
            if(map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(key, list);
            }
        }
        for(String key: map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
    
    private String getKey(String s) {
        if(s.equals("")) return "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            sb.append((s.charAt(i)-s.charAt(0) + 26)%26);
            sb.append(":");
        }
        return sb.toString();
    }
}

