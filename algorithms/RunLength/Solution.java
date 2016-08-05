public class Solution {
    public static String encode(String s) {
    	if(s == null || s.length() == 0) return "";
    	int n = s.length();
    	char cur = s.charAt(0);
    	int cnt = 1;
    	StringBuilder sb = new StringBuilder();
    	for(int i=1; i<n; i++) {
    		char c = s.charAt(i);
    		if(c == cur) {
    			cnt++;
    		} else {
    			sb.append(cnt);
    			sb.append(cur);
    			cur = c;
    			cnt = 1;
    		}
    		if(i == n-1) {
    			sb.append(cnt);
    			sb.append(cur);
    		}
    	}
    	return sb.toString();
    }
    
    public static String decode(String s) {
    	int n = s.length();
    	StringBuilder sb = new StringBuilder();
    	int start = 0;
    	for(int i=1; i<=n; i++) {
    		char c = s.charAt(i-1);
    		if(c>= '0' && c <= '9') {
    			continue;
    		} else {
    			int cnt = Integer.valueOf(s.substring(start, i-1));
    			while(cnt >0) {
    				sb.append(c);
    				cnt--;
    			}
    			start = i;
    		}
    	}
    	return sb.toString();
    }
    
	public static void main(String[] args) {
		String s1 = "aaaabbbccccccc";
		String s2 = "4a10b6c";
		System.out.println(encode(s1));
		System.out.println(decode(s2));
		System.out.println("Done");
	}
}
