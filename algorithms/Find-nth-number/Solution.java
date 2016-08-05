/*
"01234567891011", n = 9, return 10
"12131415", n = 1, return 13
*/

public class Solution {

	public static String find(String s, int m) {
		int n = s.length();
		String res = null;
		for (int i = 1; i <= n; i++) {
			String sub = s.substring(0, i);
			if(s.charAt(0) == '0' && i>1) break;
			List<String> list = new ArrayList<String>();
			list.add(sub);
			if (dfs(i, s, sub, list) && m < list.size()) {
				return list.get(m);
			}
		}
		return null;
	}

	private static boolean dfs(int start, String s, String sub, List<String> list) {
		if (start == s.length()) {
			return true;
		}
		BigInteger b0 = new BigInteger(sub);
		BigInteger b1 = b0.add(new BigInteger("1"));
		String cur = b1.toString();
		int len = cur.length();
		if (start + len > s.length()) return false;
		sub = s.substring(start, start + len);
		if (cur.equals(sub)) {
			list.add(sub);
			return dfs(start + len, s, sub, list);
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String s1 = "0134";
		System.out.println(find(s1, 1));
	}
}
