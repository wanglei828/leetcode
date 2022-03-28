/*

Given a list of daily temperatures T, return a list such that, 
for each day in the input, tells you how many days you would have to wait until a warmer temperature. 
If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], 
your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. 
Each temperature will be an integer in the range [30, 100].

*/

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        for(int i=n-2; i>=0; i--) {
            if(T[i] < T[i+1]) {
                res[i] = 1;
            } else if(T[i] == T[i+1]) {
                res[i] = (res[i+1] == 0)? 0: res[i+1]+1;
            } else {
                for(int j=i+1+res[i+1]; j<n; j++) {
                    if(T[i] < T[j] ) {
                        res[i] = j-i;
                        break;
                    } else {
                        if(res[j] == 0) {
                            break;
                        } else {
                            j += res[j]-1;
                        }
                    }
                }
            }
        }
        return res;
    }
}
