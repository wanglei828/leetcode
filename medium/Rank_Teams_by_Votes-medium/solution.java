/*
In a special ranking system, each voter gives a rank from highest to lowest to all teams participated in the competition.

The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.

Given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.

Return a string of all teams sorted by the ranking system.

 

Example 1:

Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
Output: "ACB"
Explanation: Team A was ranked first place by 5 voters. No other team was voted as first place so team A is the first team.
Team B was ranked second by 2 voters and was ranked third by 3 voters.
Team C was ranked second by 3 voters and was ranked third by 2 voters.
As most of the voters ranked C second, team C is the second team and team B is the third.
Example 2:

Input: votes = ["WXYZ","XYZW"]
Output: "XWYZ"
Explanation: X is the winner due to tie-breaking rule. X has same votes as W for the first position but X has one vote as second position while W doesn't have any votes as second position. 
Example 3:

Input: votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
Explanation: Only one voter so his votes are used for the ranking.
 

Constraints:

1 <= votes.length <= 1000
1 <= votes[i].length <= 26
votes[i].length == votes[j].length for 0 <= i, j < votes.length.
votes[i][j] is an English uppercase letter.
All characters of votes[i] are unique.
All the characters that occur in votes[0] also occur in votes[j] where 1 <= j < votes.length.
*/

class Solution {
    public String rankTeams(String[] votes) {
        int cnt = votes[0].length();
        Map<Character, int[]> map = new HashMap<>();
        for (String v : votes) {
            for (int i = 0; i < v.length(); i++) {
                char c = v.charAt(i);
                if (!map.containsKey(c)) {
                    map.put(c, new int[cnt]);
                }
                map.get(c)[i]++;
            }
        }
        Comparator<Map.Entry<Character, int[]>> com = new Comparator<>(){
            public int compare(Map.Entry<Character, int[]> o1, Map.Entry<Character,int[]> o2) {
                int[] r1 = o1.getValue();
                int[] r2 = o2.getValue();
                for (int i = 0; i < r1.length; i++) {
                    if (r1[i] != r2[i]) {
                        return r2[i] - r1[i];
                    }
                }
                return o1.getKey() - o2.getKey();
            }
        };
        PriorityQueue<Map.Entry<Character, int[]>> pq = new PriorityQueue<>(com);
        for (Map.Entry<Character, int[]> e : map.entrySet()) {
            pq.add(e);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll().getKey());
        }
        return sb.toString();
    }
}
