/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
*/

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if(A>=G || E>=C) {
            return (C-A)*(D-B) + (G-E)*(H-F);
        } 
        if(H<=B || D<=F) {
            return (C-A)*(D-B) + (G-E)*(H-F);
        }
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int bot = Math.max(B, F);
        int top = Math.min(D, H);
        return (C-A)*(D-B) + (G-E)*(H-F) - (right-left)*(top-bot);
    }
}
