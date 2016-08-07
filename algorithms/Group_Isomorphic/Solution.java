public class Solution {

	public static List<List<String>> isomorphic(String[] words) {
		if(words == null || words.length == 0) return null;
		int n = words.length;
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(int i=0; i<n; i++) {
			String str = words[i];
			String key = convert(str);
			if(!map.containsKey(key)) {
				map.put(key,  new ArrayList<String>());
			}
			map.get(key).add(str);
		}
		return new ArrayList<List<String>>(map.values());
	}
	
	public static String convert(String str) {
		if("".equals(str)) return "";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int n = str.length();
		int tag = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			char c = str.charAt(i);
			if(!map.containsKey(c)) {
				map.put(c, tag++);
			}
			sb.append(map.get(c));
			sb.append("#");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String[] arr = {"egg","add","laa","title","paper","hello","billy","kitten","how","today"};
		System.out.println(isomorphic(arr));
	}
}
