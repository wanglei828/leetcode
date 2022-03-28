/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

public class Solution {
    public String getPermutation(int n, int k) {
        if(k == 0 || n== 0) return null;
        int[] fac = new int[n+1];
        fac[0] = 1;
        for(int i=1; i<=n; i++) {
            fac[i] = i*fac[i-1];
        }
        List<Character> num = new ArrayList<Character>();
        for(int i=1; i<=n; i++) {
            num.add((char)(i+'0'));
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++) {
            int index = k/fac[n-i];
            sb.append(num.get(index));
            num.remove(index);
            k = k - index*fac[n-i];
        }
        return sb.toString();
    }
}
