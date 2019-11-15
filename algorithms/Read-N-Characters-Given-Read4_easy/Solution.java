/*
The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int sum = 0, cnt = 0;
        char[] tmp = new char[4];
        while(sum < n) {
            cnt = read4(tmp);
            if(cnt == 0) break;
            int i=0;
            while(sum<n && i<cnt) {
                buf[sum++] = tmp[i++];
            }
        }
        return sum;
    }
}
