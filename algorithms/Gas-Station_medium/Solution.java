/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null) return -1;
        if(gas.length == 0 || cost.length == 0 || gas.length != cost.length) return -1;
        int totalDiff = 0;
        int diff = 0;
        int start = 0;
        for(int i=0; i<gas.length; i++) {
            totalDiff += gas[i] - cost[i];
            diff += gas[i] - cost[i];
            if(diff < 0) {
                diff = 0;
                start = i+1;
            }
        }
        if(totalDiff < 0) return -1;
        return start;
    }
}
