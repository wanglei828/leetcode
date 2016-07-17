public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        int size = (int) Math.pow(2, n);
        result.add(0);
        int base = 1;
        while (result.size() < size) {
            List<Integer> pre = new ArrayList<Integer>(result);
            for (int i = pre.size() - 1; i >= 0; i--) {
                result.add(pre.get(i) ^ base);
            }
            base *= 2;
        }
        return result;
    }
}
