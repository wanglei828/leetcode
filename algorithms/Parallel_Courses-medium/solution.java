/*
You are given an integer n, which indicates that there are n courses labeled from 1 to n. 
You are also given an array relations where relations[i] = [prevCoursei, nextCoursei], 
representing a prerequisite relationship between course prevCoursei and course nextCoursei: course prevCoursei has to be taken before course nextCoursei.

In one semester, you can take any number of courses as long as you have taken all the prerequisites in the previous semester for the courses you are taking.

Return the minimum number of semesters needed to take all courses. If there is no way to take all the courses, return -1.

Input: n = 3, relations = [[1,3],[2,3]]
Output: 2
Explanation: The figure above represents the given graph.
In the first semester, you can take courses 1 and 2.
In the second semester, you can take course 3.

Input: n = 3, relations = [[1,2],[2,3],[3,1]]
Output: -1
Explanation: No course can be studied because they are prerequisites of each other.
 

Constraints:

1 <= n <= 5000
1 <= relations.length <= 5000
relations[i].length == 2
1 <= prevCoursei, nextCoursei <= n
prevCoursei != nextCoursei
All the pairs [prevCoursei, nextCoursei] are unique.
*/

class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] preCnt = new int[n+1];
        for (int[] re : relations) {
            int pre = re[0];
            int next = re[1];
            preCnt[next]++;
            if (map.containsKey(pre)) {
                List<Integer> list = map.get(pre);
                list.add(next);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(next);
                map.put(pre, list);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (preCnt[i] == 0) {
                q.add(i);
            }
        }
        if (q.isEmpty()) return -1;
        int taken = 0;
        int semester = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                taken++;
                if (map.containsKey(cur)) {
                    List<Integer> list = map.get(cur);
                    for (int next : list) {
                        preCnt[next]--;
                        if (preCnt[next] == 0) {
                            q.add(next);
                        }
                    }
                }
            }
            semester++;
        }
        return (taken == n) ? semester : -1;
    }
}
