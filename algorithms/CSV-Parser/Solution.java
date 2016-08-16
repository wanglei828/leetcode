/*
input:
John,Smith,john.smith@gmail.com,Los Angeles,1
Jane,Roberts,janer@msn.com,"San Francisco, CA",0
"Alexandra ""Alex""",Menendez,alex.menendez@gmail.com,Miami,1
"""Alexandra Alex"""

output:
John|Smith|john.smith@gmail.com|Los Angeles|1
Jane|Roberts|janer@msn.com|San Francisco, CA|0
Alexandra "Alex"|Menendez|alex.menendez@gmail.com|Miami|1
"Alexandra Alex"
*/

import java.util.*;

public class Solution {
	public static String csvParser(String s) {
		if(s == null || s.length() == 0) return null;
		int n = s.length();
		List<String> res = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		boolean inquote = false;
		for(int i=0; i<n; i++) {
			char c = s.charAt(i);
			if(inquote) {
				if(c == '"') {
					if(i == n-1) {
						res.add(sb.toString());
						sb.setLength(0);
						break;
					} else if(s.charAt(i+1) == '"') {
						sb.append(c);
						i++;
					} else {
						res.add(sb.toString());
						sb.setLength(0);
						inquote = false;
						i++;
					}
				} else {
					sb.append(c);
				}
			} else {
				if(c == ',') {
					res.add(sb.toString());
					sb.setLength(0);
				} else if(c == '"') {
					inquote = true;
				} else {
					sb.append(c);
				}
			}
		}
		if(sb.length() != 0) {
			res.add(sb.toString());
		}
		StringBuilder result = new StringBuilder();
		for(int i=0; i<res.size(); i++) {
			result.append(res.get(i));
			if(i != res.size()-1) {
				result.append("|");
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String str1 = "John,Smith,john.smith@gmail.com,Los Angeles,1";
		String str2 = "Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0";
		String str3 = "\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1";
		String str4 = "\"\"\"Alexandra Alex\"\"\"";
		System.out.println(csvParser(str1));
		System.out.println(csvParser(str2));
		System.out.println(csvParser(str3));
		System.out.println(csvParser(str4));
	}
}
