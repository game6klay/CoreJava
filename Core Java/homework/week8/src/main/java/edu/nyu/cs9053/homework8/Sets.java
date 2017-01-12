package edu.nyu.cs9053.homework8;

import java.util.*;

/**
 * User: blangel
 * Date: 10/14/14
 * Time: 6:47 PM
 */
public class Sets {


    public static <T>Set<T> union(Set<T> left, Set<T> right) {

        Iterator<T> setLeft=left.iterator();
        Iterator<T> setRight=right.iterator();

        Set<T> set=new HashSet<T>(left.size()+right.size());

        while(setLeft.hasNext() || setRight.hasNext()) {
            T Sum = setLeft.next();
            set.add(Sum);

            Sum = setRight.next();
            set.add(Sum);
        }

        return set;

        }

    public static <T>Set<T> intersection(Set<T> left, Set<T> right){

        Iterator<T> setLeft=left.iterator();
        Set<T> intersectSet=new HashSet<T>(left.size());

        while(setLeft.hasNext()){
            T Comparator=setLeft.next();
            if(right.contains(Comparator)){
                intersectSet.add(Comparator);
            }
        }
        return intersectSet;


    }

    public static <T>Set<T> symmetricDifference(Set<T> left, Set<T> right) {

        Set<T> union = new HashSet<>(union(left, right));
        Iterator<T> unionSet=union.iterator();
        Set<T> intersection = new HashSet<>(intersection(left, right));
            while(unionSet.hasNext()){
                T Comparator=unionSet.next();
                if(intersection.contains(Comparator)){
                    intersection.remove(Comparator);
                }
            }
            return union;

    }

}
