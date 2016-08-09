/*
support all kinds of basic operation.
"100 * ( 2 + 12 )- (20 + 3)*2" = 1354
*/

public class Solution {

	public static int calculator(String s) {
		if (s == null || s.length() == 0) return 0;
		Stack<Character> ops = new Stack<Character>();
		Stack<Integer> vals = new Stack<Integer>();
		s = s.trim();
		s = s.replaceAll(" ", "");
		s = s + "#";
		int cur = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c >= '0' && c <= '9') {
				cur = cur * 10 + c - '0';
			} else {
				if(c == '(') {
					ops.push(c);
					cur = 0;
					continue;
				}
				if(!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
					char op = ops.pop();
					int a = vals.pop();
					if(op == '*') {
						cur = a*cur;
					} else {
						cur = a/cur;
					}
				}
				switch (c) {
				case '+':
				case '-':
				case '*':
				case '/':
					vals.push(cur);
					ops.push(c);
					cur = 0;
					break;
				case ')':
					while(ops.peek() != '(') {
						char op = ops.pop();
						int a = vals.pop();
						if(op == '+') {
							cur = a + cur;
						} else {
							cur = a - cur;
						}
					}
					ops.pop();
					break;
				case '#':
					while(!ops.isEmpty()) {
						char op = ops.pop();
						int a = vals.pop();
						if(op == '+') {
							cur = a + cur;
						} else {
							cur = a - cur;
						}						
					}
				}
			}
		}
		return cur;
	}

	public static void main(String[] args) {
		String s1 = "1+2*3/2-1";
		String s2 = "(1+2)*3-4*(5-8)";
		String s3 = "100 * ( 2 + 12 )- (20 + 3)*2";
		System.out.println(calculator(s1));
		System.out.println(calculator(s2));
		System.out.println(calculator(s3));
	}
}
