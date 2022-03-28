/*
You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

 

Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation: 
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
Example 3:

Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 

Constraints:

1 <= equations.length <= 20
equations[i].length == 2
1 <= Ai.length, Bi.length <= 5
values.length == equations.length
0.0 < values[i] <= 20.0
1 <= queries.length <= 20
queries[i].length == 2
1 <= Cj.length, Dj.length <= 5
Ai, Bi, Cj, Dj consist of lower case English letters and digits.
*/

class Solution {
    HashMap<String, HashMap<String, Double>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double val = values[i];
            if (graph.containsKey(a)) {
                graph.get(a).put(b, val);
            } else {
                HashMap<String, Double> map = new HashMap<>();
                map.put(b, val);
                graph.put(a, map);
            }
            if (graph.containsKey(b)) {
                graph.get(b).put(a, 1/val);
            } else {
                HashMap<String, Double> map = new HashMap<>();
                map.put(a, 1/val);
                graph.put(b, map);
            }
        }
        
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!graph.containsKey(a)) {
                res[i] = -1.0;
            } else if (a.equals(b)) {
                res[i] = 1.0;
            } else {
                Set<String> visit = new HashSet<>();
                res[i] = dfs(a, b, visit, 1.0);
            }
        }
        return res;
    }
    
    private double dfs(String divend, String divor, Set<String> visit, double cur) {
        if (divend.equals(divor)) return cur;
        visit.add(divend);
        double res = -1.0;
        HashMap<String, Double> map = graph.get(divend);
        for (String s : map.keySet()) {
            if (visit.contains(s)) continue;
            res = dfs(s, divor, visit, cur*map.get(s));
            if (res != -1.0) {
                break;
            }
        }
        return res;
    }
}
