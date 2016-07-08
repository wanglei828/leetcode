/*
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
*/

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || A.length == 0 || A[0].length == 0) return new int[0][0];
        if(B == null || B.length == 0 || B[0].length == 0) return new int[0][0];
        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;
        int[][] res = new int[m][l];
        Map<Integer, Map<Integer, Integer>> mapA = new HashMap<Integer, Map<Integer, Integer>>();
        Map<Integer, Map<Integer, Integer>> mapB = new HashMap<Integer, Map<Integer, Integer>>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(A[i][j] != 0) {
                    if(mapA.containsKey(i)) {
                        mapA.get(i).put(j, A[i][j]);
                    } else {
                        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                        map.put(j, A[i][j]);
                        mapA.put(i, map);
                    }
                }
            }
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<l; j++) {
                if(B[i][j] != 0) {
                    if(mapB.containsKey(i)) {
                        mapB.get(i).put(j, B[i][j]);
                    } else {
                        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                        map.put(j, B[i][j]);
                        mapB.put(i, map);
                    }
                }
            }
        }
        for(int i: mapA.keySet()) {
            for(int j: mapA.get(i).keySet()) {
                if(!mapB.containsKey(j)) {
                    continue;
                }
                for(int k: mapB.get(j).keySet()) {
                    res[i][k] += mapA.get(i).get(j) * mapB.get(j).get(k);
                }
            }
        }
        return res;
    }
}
