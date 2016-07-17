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
    private int bufptr = 0;
    private int bufcnt = 0;
    public int read(char[] buf, int n) {
        int sum = 0;
        while(sum<n) {
            if(bufptr == 0) {
                bufcnt = read4(rf);
            }
            if(bufcnt == 0) break;
            while(sum<n) {
                buf[sum++] = rf[bufptr++];
                if(bufptr == bufcnt) {
                    bufptr = 0;
                    break;
                }
            }
        }
        return sum;
    }
}
