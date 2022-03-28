/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Note:
The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
*/

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites== null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
        int[] depend = new int[numCourses];
        Arrays.fill(depend, 0);
        int count = 0;
        for(int i=0; i<prerequisites.length; i++) {
            depend[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++) {
            if(depend[i] == 0) {
                q.add(i);
                count++;
            }
        }
        if(count == numCourses) return true;
        if(count == 0) return false;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i=0; i<prerequisites.length; i++) {
                if(depend[prerequisites[i][0]] != 0 && prerequisites[i][1] == cur) {
                    depend[prerequisites[i][0]]--;
                    if(depend[prerequisites[i][0]] == 0) {
                        q.add(prerequisites[i][0]);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}
