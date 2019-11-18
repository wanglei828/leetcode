/*

Given a char array representing tasks CPU need to do. 
It contains capital letters A to Z where different letters represent different tasks. 
Tasks could be done without original order. Each task could be done in one interval. 
For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, 
there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

 

Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 

Note:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].

*/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c : tasks) {
            count[c-'A']++;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for(int i=0; i<16; i++) {
            if(count[i] != 0) {
                q.add(count[i]);
            }
        }
        int inter = 0;
        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int i=0;
            while(i<(n+1) && !q.isEmpty()) {
                int cur = q.poll();
                list.add(cur);
                i++;
            }
            for(Integer j: list) {
                if(j > 1) {
                    q.add(j-1);
                }
            }
            if (q.isEmpty()) {
                inter += list.size();
            } else {
                inter += n+1;
            }
        }
        return inter;
    }
}
