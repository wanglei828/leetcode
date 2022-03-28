public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(freqMap.containsKey(nums[i])) {
                freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
            } else {
                freqMap.put(nums[i], 1);
            }
        }
        List<Integer>[] freq = new List[nums.length+1];
        for(Integer key:freqMap.keySet()) {
            int v = freqMap.get(key);
            if(freq[v] == null) {
                freq[v] = new ArrayList<Integer>();
                freq[v].add(key);
            } else {
                freq[v].add(key);
            }
        }

        List<Integer> res = new LinkedList<Integer>();
        for(int i = nums.length; i>=0 && res.size()<k; i--) {
            if(freq[i] != null) {
                res.addAll(freq[i]);
            }
        }
        return res;
    }
}
