/*

We are given N different types of stickers. Each sticker has a lowercase English word on it.

You would like to spell out the given target string by 
cutting individual letters from your collection of stickers and rearranging them.

You can use each sticker more than once if you want, and you have infinite quantities of each sticker.

What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.

Example 1:

Input:

["with", "example", "science"], "thehat"
Output:

3
Explanation:

We can use 2 "with" stickers, and 1 "example" sticker.
After cutting and rearrange the letters of those stickers, we can form the target "thehat".
Also, this is the minimum number of stickers necessary to form the target string.
Example 2:

Input:

["notice", "possible"], "basicbasic"
Output:

-1
Explanation:

We can't form the target "basicbasic" from cutting letters from the given stickers.
Note:

stickers has length in the range [1, 50].
stickers consists of lowercase English words (without apostrophes).
target has length in the range [1, 15], and consists of lowercase English letters.
In all test cases, all words were chosen randomly from the 1000 most common US English words, 
and the target was chosen as a concatenation of two random words.
The time limit may be more challenging than usual. 
It is expected that a 50 sticker test case can be solved within 35ms on average.

*/

class Solution {
  int minStickers = Integer.MAX_VALUE;

	public int minStickers(String[] stickers, String target) {
		// Start of preprocessing
		Set<Character> targetChars = new HashSet<Character>();
		for (char c : target.toCharArray()) targetChars.add(c); // Get all chars in target.
		Set<String> usableStickers = new HashSet<String>();
		for (String s : stickers) {
			String prunedSticker = getPrunedSticker(s, targetChars);
			if (!prunedSticker.equals("")) usableStickers.add(prunedSticker); // Get all stickers which contains any char in target
		}

		int size = usableStickers.size();
		stickers = new String[size];
		for (String s : usableStickers) stickers[--size] = s;

		Arrays.sort(stickers, (a, b) -> b.length() - a.length());
		for (int i = 0; i < stickers.length; ++i) {
			for (int j = i + 1; j < stickers.length; ++j) {
				if (usableStickers.contains(stickers[j]) && dominates(stickers[i], stickers[j])) {
					usableStickers.remove(stickers[j]); // remove dominated sticker
				}
			}
		} // end of preprocessing

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		dfs(usableStickers, target, map, 0, 0);
		return minStickers == Integer.MAX_VALUE ? -1 : minStickers;
	}

	private void dfs(Set<String> stickers, String target, Map<Character, Integer> map, int pos, int cnt) {
		if (cnt >= minStickers) return;
		if (pos == target.length()) {
			minStickers = Math.min(minStickers, cnt);
			return;
		}
		char t = target.charAt(pos);
		if (map.containsKey(t) && map.get(t) > 0) {
			map.put(t, map.get(t) - 1);
			dfs(stickers, target, map, pos + 1, cnt);
			map.put(t, map.get(t) + 1);
			return;
		}

		for (String sticker : stickers) {
			if (!sticker.contains(String.valueOf(t))) continue;
			for (char c : sticker.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
			map.put(t, map.get(t) - 1);
			dfs(stickers, target, map, pos + 1, cnt + 1);
			map.put(t, map.get(t) + 1);
			for (char c : sticker.toCharArray()) map.put(c, map.get(c) - 1);
		}
	}
    // used for preprocessing
	private boolean dominates(String A, String B) {
		int[] charCount = new int[26];
		for (char c : A.toCharArray()) charCount[c - 'a']++;
		for (char c : B.toCharArray()) charCount[c - 'a']--;
		for (int i = 0; i < 26; ++i)
			if (charCount[i] < 0)
				return false;
		return true;
	}
    // used for preprocessing
	private String getPrunedSticker(String s, Set<Character> targetChars) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (targetChars.contains(c))
				sb.append(c);
		}
		return sb.toString();
	}
}
