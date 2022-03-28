public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n == 1) return true;
        if(edges == null || edges.length == 0 ) return false;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i=0; i<edges.length; i++) {
            if(map.containsKey(edges[i][0])) {
                map.get(edges[i][0]).add(edges[i][1]);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(edges[i][1]);
                map.put(edges[i][0], list);
            }
            if(map.containsKey(edges[i][1])) {
                map.get(edges[i][1]).add(edges[i][0]);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(edges[i][0]);
                map.put(edges[i][1], list);
            }
        }
        if(map.size() != n) return false;
        Set<Integer> set = new HashSet<Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        while(!q.isEmpty()) {
            int node = q.poll();
            if(set.contains(node)) {
                return false;
            }
            set.add(node);
            List<Integer> list = map.get(node);
            for(Integer i:list) {
                q.add(i);
                map.get(i).remove(new Integer(node));
            }
        }
        return set.size() == n;
    }
}
