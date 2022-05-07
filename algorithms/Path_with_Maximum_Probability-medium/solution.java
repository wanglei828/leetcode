/*
You are given an undirected weighted graph of n nodes (0-indexed), 
represented by an edge list where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability of success of traversing that edge succProb[i].

Given two nodes start and end, find the path with the maximum probability of success to go from start to end and return its success probability.

If there is no path from start to end, return 0. Your answer will be accepted if it differs from the correct answer by at most 1e-5.

 

Example 1:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.2], start = 0, end = 2
Output: 0.25000
Explanation: There are two paths from start to end, one having a probability of success = 0.2 and the other has 0.5 * 0.5 = 0.25.
Example 2:



Input: n = 3, edges = [[0,1],[1,2],[0,2]], succProb = [0.5,0.5,0.3], start = 0, end = 2
Output: 0.30000
Example 3:



Input: n = 3, edges = [[0,1]], succProb = [0.5], start = 0, end = 2
Output: 0.00000
Explanation: There is no path between 0 and 2.
 

Constraints:

2 <= n <= 10^4
0 <= start, end < n
start != end
0 <= a, b < n
a != b
0 <= succProb.length == edges.length <= 2*10^4
0 <= succProb[i] <= 1
There is at most one edge between every two nodes.
*/

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<Pair<Integer, Double>>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            double p = succProb[i];
            int u = edges[i][0];
            int v = edges[i][1];
            if (!map.containsKey(u)) {
                map.put(u, new ArrayList<Pair<Integer, Double>>());
            }
            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<Pair<Integer, Double>>());
            }
            map.get(u).add(new Pair<Integer, Double>(v, p));
            map.get(v).add(new Pair<Integer, Double>(u, p));
        }
        PriorityQueue<Pair<Integer, Double>> q = new PriorityQueue<>(new Comparator<Pair<Integer, Double>>() {
           public int compare(Pair<Integer, Double> p1, Pair<Integer, Double> p2) {
                    return Double.compare(p2.getValue(), p1.getValue());
                }
        });
        boolean[] visit = new boolean[n];
        if (!map.containsKey(start)) {
            return 0.0;
        }
        for (Pair<Integer, Double> p : map.get(start)) {
            q.add(p);
        }
        while (!q.isEmpty()) {
            Pair<Integer, Double> cur = q.poll();
            int id = cur.getKey();
            double prob = cur.getValue();
            if (id == end) {
                return prob;
            }
            if (visit[id]) {
                continue;
            } else {
                visit[id] = true;
            }
            if (!map.containsKey(id)) {
                continue;
            }
            for (Pair<Integer, Double> p: map.get(id)) {
                q.add(new Pair<Integer, Double>(p.getKey(), prob * p.getValue()));
            }
        }
        return 0.0;
    }
}
