package OverlappingRectangle;

/**
 * Created by jay on 1/6/17.
 */
public class Solution {

    // l1(x,y) (x1,y1)
    // r1(x,y) (x2,y2)
    // l2(x,y) (x3,y2)
    // r2(x,y) (x4,y4)

    // y2 > y3
    // x1 > x4
    // y1 < y4
    // x2 < x3

    // (Math.max(y1,y2) < Math.min(y3,y4) || Math.min(y1,y2) > Math.max(y3,y4))
    // || (Math.max(yi,y2) < Math.min(y3,y4) || Math.min(y1,y2) > Math.max(y3,y4))
}


