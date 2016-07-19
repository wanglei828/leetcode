/*
An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. 
The black pixels are connected, i.e., there is only one black region. 
Pixels are connected horizontally and vertically. 
Given the location (x, y) of one of the black pixels, 
return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.
*/

public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        int[] vert = new int[m];
        int minX = searchRow(image, 0, x, 0);
        int maxX = searchRow(image, x, m-1, 1);
        int minY = searchCol(image, 0, y, 0);
        int maxY = searchCol(image, y, n-1, 1);
        return (maxX-minX+1)*(maxY-minY+1);
    }
    
    private int searchRow(char[][] image, int h, int t, int dir) {
        if(h == t) return h;
        int n = image[0].length;
        while(h<=t) {
            int m = h + (t-h)/2;
            boolean find = false;
            for(int i=0; i<n; i++) {
                if(image[m][i] == '1') {
                    find = true;
                    break;
                }
            }
            if(find) {
                if(dir == 0){
                    t = m-1;
                } else {
                    h = m+1;
                }
            } else {
                if(dir == 0) {
                    h = m+1;
                } else {
                    t = m-1;
                }
            }
        }
        return (dir == 0)? h : t;
    }
    
    private int searchCol(char[][] image, int h, int t, int dir) {
        if(h == t) return h;
        int n = image.length;
        while(h<=t) {
            int m = h + (t-h)/2;
            boolean find = false;
            for(int i=0; i<n; i++) {
                if(image[i][m] == '1') {
                    find = true;
                    break;
                }
            }
            if(find) {
                if(dir == 0){
                    t = m-1;
                } else {
                    h = m+1;
                }
            } else {
                if(dir == 0) {
                    h = m+1;
                } else {
                    t = m-1;
                }
            }
        }
        return (dir == 0)? h : t;
    }
}
