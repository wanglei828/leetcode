/*
A row-sorted binary matrix means that all elements are 0 or 1 and each row of the matrix is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return the index (0-indexed) of the leftmost column with a 1 in it. If such an index does not exist, return -1.

You can't access the Binary Matrix directly. You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
BinaryMatrix.dimensions() returns the dimensions of the matrix as a list of 2 elements [rows, cols], which means the matrix is rows x cols.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes, the input will be the entire binary matrix mat. You will not have access to the binary matrix directly.

Input: mat = [[0,0],[1,1]]
Output: 0

Input: mat = [[0,0],[0,1]]
Output: 1

Input: mat = [[0,0],[0,0]]
Output: -1
 

Constraints:

rows == mat.length
cols == mat[i].length
1 <= rows, cols <= 100
mat[i][j] is either 0 or 1.
mat[i] is sorted in non-decreasing order.
*/

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    int res;
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(1);
        List<Integer> rows = new ArrayList<>();
        for(int i = 0; i < m; i ++) {
            if (binaryMatrix.get(i, n-1) == 1) {
                rows.add(i);
            }
        }
        if (rows.size() == 0) {
            return -1;
        }
        res = n;
        for (int i = 0; i < rows.size(); i++) {
            int left = search(binaryMatrix, rows.get(i), n);
            res = Math.min(res, left);
        }
        return res;
    }
    
    private int search(BinaryMatrix matrix, int row, int n) {
        int h = 0;
        int t = n-1;
        while (h < t) {
            int m = h + (t-h)/2;
            if (matrix.get(row, m) == 1) {
                t = m;
            } else {
                h = m + 1;
            }
        }
        return t;
    }
}
