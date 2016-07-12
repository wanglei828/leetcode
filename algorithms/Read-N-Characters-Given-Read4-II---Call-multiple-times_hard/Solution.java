/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. 
For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] rf = new char[4];
    private int offset = 3;
    private int last = 3;
    public int read(char[] buf, int n) {
        int sum = 0;
        boolean eof = false; 
        for(int i=offset; i<last && sum<n; i++) {
            buf[sum] = rf[i];
            sum++;
            offset++;
        }
        while(sum<n && !eof) {
            int cur = read4(rf);
            if(cur < 4){
                eof = true;
            }
            int i=0;
            for(; i<cur && sum<n; i++) {
                buf[sum] = rf[i];
                sum++;
            }
            if(i<cur) {
                offset = i;
                last = cur;
            }
        }
        return sum;
    }
}
