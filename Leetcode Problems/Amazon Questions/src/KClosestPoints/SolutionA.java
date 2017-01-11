package KClosestPoints;

import java.util.*;

/**
 * Created by jay on 1/7/17.
 */
public class SolutionA {
    static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString(){
            return "("+x+","+y+")\n";
        }
    }

    public static void main(String[] args) {
        SolutionA solutionA = new SolutionA();

        int k=5;

        SolutionA.Point[] K = solutionA.getSmallestK(new SolutionA.Point[]{
                new SolutionA.Point(1, 1),
                new SolutionA.Point(1, 2),
                new SolutionA.Point(2, 1),
                new SolutionA.Point(2, 2),
                new SolutionA.Point(3, 3),
                new SolutionA.Point(4, 4),
                new SolutionA.Point(3, 4),

        }, k);

        for (int i=0; i<k; i++) {
            System.out.println(K[i]);
        }
    }

    SolutionA.Point[] getSmallestK(SolutionA.Point[] points, int k) {
        List<SolutionA.Point> array = new ArrayList<>(Arrays.asList(points));
        ArrayList<SolutionA.Point> smallestK = new ArrayList<>();

        for (int i=0; i<k; i++) {
            SolutionA.Point max = array.get(0);
            int j=0, maxIndex=0;
            for (SolutionA.Point current : array) {

                if (distance(max, current)>0) {
                    max = current;
                    maxIndex=j;
                }
                j++;
            }
            //System.out.println("max "+max);
            array.remove(maxIndex);
            //System.out.println(array.get(maxIndex));

            smallestK.add(max);
        }
        return smallestK.toArray(new SolutionA.Point[k]);
    }

    // FIXME:
    public int distance(Point p1, Point p2) {
        return Double.compare(Math.sqrt((p1.x*p1.x) + (p1.y*p1.y)), 
                Math.sqrt((p2.y*p2.y) + (p2.x*p2.x)));
    }
}
