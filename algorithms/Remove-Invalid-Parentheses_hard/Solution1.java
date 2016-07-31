public class Solution {
    List<String> res = new ArrayList<String>();
    public List<String> removeInvalidParentheses(String s) {
        if(s == null || s.length() == 0) {
            res.add(s);
            return res;
        }
        char[] strArr = s.toCharArray();
        helperFront(strArr, 0, -1);
        return res;
    }
    
    private void helperFront(char[] arr, int start, int last) {
        int left = 0;
        int right = 0;
        int cur = start;
        int i = start;
        for(; i<arr.length; i++) {
            if(arr[i] == '(') {
                left++;
            } else if(arr[i] == ')') {
                right++;
            }
            if(right > left) {
                cur = i;
                break;
            }
        }
        if(i == arr.length) {
            helperEnd(arr, i-1, arr.length);
            return;
        }
        for(i=0; i<=cur; i++) {
            if(arr[i] == ')') {
                if(i>0 && arr[i-1] == ')' || i <= last) continue;
                arr[i] = '\0';
                helperFront(arr, cur+1, i);
                arr[i] = ')';
            }
        }
    }
    
    private void helperEnd(char[] arr, int end, int last) {
        int left = 0;
        int right = 0;
        int cur = end;
        int i = end;
        for(; i>=0; i--) {
            if(arr[i] == '(') {
                left++;
            } else if(arr[i] == ')') {
                right++;
            }
            if(right < left) {
                cur = i;
                break;
            }
        }
        if(i < 0) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<arr.length; j++) {
                if(arr[j] != '\0')  {
                    sb.append(arr[j]);
                }
            }
            res.add((sb.length()==0)? "" : sb.toString());
            return;
        }
        for(i=arr.length-1; i>=cur; i--) {
            if(arr[i] == '(') {
                if(i<arr.length-1 && arr[i+1] == '(' || i >= last) continue;
                arr[i] = '\0';
                helperEnd(arr, cur-1, i);
                arr[i] = '(';
            }
        }
    }
}
