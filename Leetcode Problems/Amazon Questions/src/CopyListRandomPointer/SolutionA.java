package CopyListRandomPointer;

/**
 * Created by jay on 1/6/17.
 */
public class SolutionA {

    public RandomListNode copyRandomList (RandomListNode head) {

        if (head == null){

            return null;
        }

        // copy every node and insert it into the list
        // copy random pointers for all newly created node
        // break the list into two

        RandomListNode p =head;

        while (p!= null) {

            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }

        // copy random pointer for each new node
        p = head;
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }

        // break list to two
        p = head;
        RandomListNode newHead = head.next;
        while (p != null) {
            RandomListNode temp = p.next;
            p.next = temp.next;
            if (temp.next != null)
                temp.next = temp.next.next;
            p = p.next;
        }

        return newHead;


    }

}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
