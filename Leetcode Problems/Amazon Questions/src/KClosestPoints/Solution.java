package KClosestPoints;

import java.util.*;

/**
 * Created by jay on 1/7/17.
 */
public class Solution {

    public List<Point> nearestKPoint(List<Point> list, final Point center, int k) {

        // define the Array list I would insert all the k nearest point
        List<Point> result = new ArrayList<>();
        // initiate the PriorityQueue
        PriorityQueue<Point> maxHeap = new PriorityQueue<>(k + 1, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return distance(center ,o1) - distance(center, o2);
            }
        });

        // first put all the values of given array or list of points in to the priority queue

        for (Point p: list) {

            maxHeap.offer(p);
            if (maxHeap.size() >k) {

                maxHeap.poll();
                // FIXME:
            }
        }
        // iterate through the PriorityQueue and insert all the elements in the

        Iterator<Point> i = maxHeap.iterator();

        while(i.hasNext()) {

            result.add(i.next());
        }
        return result;

    }

    public static void main(String[] args) {

        List<Point> list = new ArrayList<>();

    }

    // FIXME:
    public int distance(Point p1, Point p2) {

        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y -p2.y);
    }

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {

            this.x =x;
            this.y =y;

        }

        public int hashcode() {

            int result = x;
            result = 31 *result +y;
            return result;
        }

        public boolean equals (Object obj) {

            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {

                return false;
            }

            Point point = (Point)obj;

            if (point.x != ((Point) obj).x) {
                return false;
            }

            return point.y == ((Point) obj).y;


        }
    }


}

