/*
You are given two 0-indexed integer arrays servers and tasks of lengths n​​​​​​ and m​​​​​​ respectively. servers[i] is the weight of the i​​​​​​th​​​​ server, and tasks[j] is the time needed to process the j​​​​​​th​​​​ task in seconds.

Tasks are assigned to the servers using a task queue. Initially, all servers are free, and the queue is empty.

At second j, the jth task is inserted into the queue (starting with the 0th task being inserted at second 0). As long as there are free servers and the queue is not empty, the task in the front of the queue will be assigned to a free server with the smallest weight, and in case of a tie, it is assigned to a free server with the smallest index.

If there are no free servers and the queue is not empty, we wait until a server becomes free and immediately assign the next task. If multiple servers become free at the same time, then multiple tasks from the queue will be assigned in order of insertion following the weight and index priorities above.

A server that is assigned task j at second t will be free again at second t + tasks[j].

Build an array ans​​​​ of length m, where ans[j] is the index of the server the j​​​​​​th task will be assigned to.

Return the array ans​​​​.

 

Example 1:

Input: servers = [3,3,2], tasks = [1,2,3,2,1,2]
Output: [2,2,0,2,1,2]
Explanation: Events in chronological order go as follows:
- At second 0, task 0 is added and processed using server 2 until second 1.
- At second 1, server 2 becomes free. Task 1 is added and processed using server 2 until second 3.
- At second 2, task 2 is added and processed using server 0 until second 5.
- At second 3, server 2 becomes free. Task 3 is added and processed using server 2 until second 5.
- At second 4, task 4 is added and processed using server 1 until second 5.
- At second 5, all servers become free. Task 5 is added and processed using server 2 until second 7.
Example 2:

Input: servers = [5,1,4,3,2], tasks = [2,1,2,4,5,2,1]
Output: [1,4,1,4,1,3,2]
Explanation: Events in chronological order go as follows: 
- At second 0, task 0 is added and processed using server 1 until second 2.
- At second 1, task 1 is added and processed using server 4 until second 2.
- At second 2, servers 1 and 4 become free. Task 2 is added and processed using server 1 until second 4. 
- At second 3, task 3 is added and processed using server 4 until second 7.
- At second 4, server 1 becomes free. Task 4 is added and processed using server 1 until second 9. 
- At second 5, task 5 is added and processed using server 3 until second 7.
- At second 6, task 6 is added and processed using server 2 until second 7.
 

Constraints:

servers.length == n
tasks.length == m
1 <= n, m <= 2 * 105
1 <= servers[i], tasks[j] <= 2 * 105
*/

class Solution {
    PriorityQueue<int[]> sq;
    Queue<Integer> tq;
    public int[] assignTasks(int[] servers, int[] tasks) {
        sq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        for (int i = 0; i < servers.length; i++) {
            sq.add(new int[]{servers[i], i});
        }
        tq = new LinkedList<>();
        tq.add(0);
        int time = 0;
        int[] res = new int[tasks.length];
        int index = 1;
        Map<Integer, List<int[]>> freeMap = new HashMap<>();
        PriorityQueue<Integer> minTime = new PriorityQueue<>();
        while(!tq.isEmpty()) {
            if (freeMap.containsKey(time)) {
                for (int[] server : freeMap.get(time)) {
                    sq.add(server);
                }
                while (!minTime.isEmpty() && minTime.peek() <= time) {
                    minTime.poll();
                }
            }
            while (!sq.isEmpty() && !tq.isEmpty()) {
                int task = tq.poll();
                int req_time = tasks[task];
                int server_id = sq.peek()[1];
                int weight = sq.poll()[0];
                int free_time = time + req_time;
                res[task] = server_id;
                if (!freeMap.containsKey(free_time)) {
                    freeMap.put(free_time, new ArrayList<int[]>());
                }
                freeMap.get(free_time).add(new int[]{weight, server_id});
                minTime.add(free_time);
                
            }
            if (sq.isEmpty()) {
                time = minTime.peek();
            } else {
                time++;
            }
            while(index < tasks.length && index <= time) {
                tq.add(index);
                index++;
            }
        }
        return res;
    }

}
