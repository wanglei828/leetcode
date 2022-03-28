/*
You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.

You can swap the characters at any pair of indices in the given pairs any number of times.

Return the lexicographically smallest string that s can be changed to after using the swaps.

 

Example 1:

Input: s = "dcab", pairs = [[0,3],[1,2]]
Output: "bacd"
Explaination: 
Swap s[0] and s[3], s = "bcad"
Swap s[1] and s[2], s = "bacd"
Example 2:

Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
Output: "abcd"
Explaination: 
Swap s[0] and s[3], s = "bcad"
Swap s[0] and s[2], s = "acbd"
Swap s[1] and s[2], s = "abcd"
Example 3:

Input: s = "cba", pairs = [[0,1],[1,2]]
Output: "abc"
Explaination: 
Swap s[0] and s[1], s = "bca"
Swap s[1] and s[2], s = "bac"
Swap s[0] and s[1], s = "abc"
 

Constraints:

1 <= s.length <= 10^5
0 <= pairs.length <= 10^5
0 <= pairs[i][0], pairs[i][1] < s.length
s only contains lower case English letters.
*/

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        char[] sa = s.toCharArray();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (List<Integer> pair : pairs) {
            int p0 = pair.get(0);
            int p1 = pair.get(1);
            if (map.containsKey(p0)) {
                map.get(p0).add(p1);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(p1);
                map.put(p0, list);
            }
            if (map.containsKey(p1)) {
                map.get(p1).add(p0);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(p0);
                map.put(p1, list);
            }
        }
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            List<Integer> index = new ArrayList<>();
            List<Character> cl = new ArrayList<>();
            dfs(i, index, cl, map, visit, sa);
            Collections.sort(index);
            Collections.sort(cl);
            for (int j = 0; j < index.size(); j++) {
                sa[index.get(j)] = cl.get(j);
            }
        }
        String res = new String(sa);
        return res;
    }   
    
    private void dfs(int cur, List<Integer> index, List<Character> cl, HashMap<Integer, List<Integer>> map, boolean[] visit, char[] sa) {
        if (visit[cur]) return;
        visit[cur] = true;
        index.add(cur);
        cl.add(sa[cur]);
        if (map.containsKey(cur)) {
            List<Integer> list = map.get(cur);
            for (int i = 0; i < list.size(); i++) {
                dfs(list.get(i), index, cl, map, visit, sa);
            }
        }
    }
}
