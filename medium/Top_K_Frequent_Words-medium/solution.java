/*

Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. 
If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.

*/

import javafx.util.Pair;
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++) {
            String str = words[i];
            if(map.containsKey(str)) {
                map.put(str, map.get(str)+1);
            } else {
                map.put(str, 1);
            }
        }
        PriorityQueue<Pair<String, Integer>> q = new PriorityQueue<>(new Comparator<Pair<String, Integer>>(){
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                return (o2.getValue() == o1.getValue())? o1.getKey().compareTo(o2.getKey()): o2.getValue() - o1.getValue();
            }
        });
        for(String s: map.keySet()) {
            q.add(new Pair(s, map.get(s)));
        }
        List<String> res = new ArrayList<String>();
        for(int i=0; i<k; i++) {
            res.add(q.poll().getKey());
        }
        return res;
    }
}
