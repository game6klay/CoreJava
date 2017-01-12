package edu.nyu.cs9053.homework8;

import java.util.*;

/**
 * User: blangel
 * Date: 10/14/14
 * Time: 6:47 PM
 */
public class Lists {

    public static<T> List shuffle(T list) {

        List <T> anyList = new LinkedList<>();

        // can also use collection.shuffle method

        Collections.shuffle(anyList);

        // else this one

        int listSize=((List) list).size();
        while(listSize>0){
            int randomIndex=(int)((Math.random()*listSize));
            T temp = anyList.get(randomIndex);
            anyList.set(listSize, temp);
            listSize--;
        }

        return anyList;
    }

    public static<T> boolean deepEquals(List<T> left, List<T> right) {

        int sizeLeft = left.size();
        int sizeRight = right.size();

        if ((sizeLeft == 0) && sizeLeft != sizeRight ){
            return false;
        }

        else

            for (T leftVal : left) {
                for (T rightVal : right) {
                    if (!leftVal.equals(rightVal)) {
                        return false;
                    }
                }
            }
        return true;

    }

}
