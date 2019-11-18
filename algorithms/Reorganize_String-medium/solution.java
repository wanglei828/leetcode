/*

Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
Example 2:

Input: S = "aaab"
Output: ""
Note:

S will consist of lowercase letters and have length in range [1, 500].

*/

class Solution {
    public String reorganizeString(String S) {
        if(S == null || S.length() == 0) return "";
        int[] count = new int[26];
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            count[c-'a']++;
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for(int i=0; i<26; i++) {
            if(count[i] != 0) {
                q.add(new int[]{i, count[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        int pre = -1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] != pre) {
                sb.append((char)(cur[0] + 'a'));
                cur[1]--;
                if(cur[1] > 0) {
                    q.add(cur);
                }
                pre = cur[0];
            } else {
                if(!q.isEmpty()) {
                    int[] tmp = q.poll();
                    sb.append((char)(tmp[0] + 'a'));
                    tmp[1]--;
                    if(tmp[1] > 0) {
                       q.add(tmp); 
                    }
                    q.add(cur);
                    pre = tmp[0];
                } else {
                    return "";
                }
            }
        }
        return sb.toString();
    }
}
