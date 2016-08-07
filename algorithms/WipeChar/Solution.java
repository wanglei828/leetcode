/*
Input "abceaef", 'a'
Output: "bceef"
*/

public class Solution {
	public static String wipeChar(String s, char c) {
		if(s == null) return null;
		int pos = 0;
		int n = s.length();
		char[] arr = s.toCharArray();
		for(int i=0; i<n; i++) {
			if(arr[i] != c) {
				arr[pos] = arr[i];
				pos++;
			}
		}
		return new String(arr, 0, pos);
	}
	public static void main(String[] args) {
		String str = "abcadef";
		char c = 'a';
		System.out.println(wipeChar(str, c));
	}
}
