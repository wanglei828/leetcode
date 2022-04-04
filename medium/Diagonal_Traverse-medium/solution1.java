class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i + j;
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(mat[i][j]);
                index = Math.max(index, key);
            }
        }
        int[] res = new int[m*n];
        int pos = 0;
        for (int i = 0; i <= index; i++) {
            if (map.containsKey(i)) {
                List<Integer> list = map.get(i);
                if (i % 2 == 0) {
                    for (int j = list.size()-1; j >= 0; j--) {
                        res[pos++] = list.get(j);
                    }
                } else {
                    for (int j = 0; j < list.size(); j++) {
                        res[pos++] = list.get(j);
                    }
                }
            }
        }
        return res;
    }
}
