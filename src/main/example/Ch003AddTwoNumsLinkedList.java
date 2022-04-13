package example;
// solving for Ch002TwoSum.java
// given two linkedLists that store a number in reverse order
//      Example: 1234 is stored as 4<->3<->2<->1
// add the two numbers from the linked list and store the sum in the same fashion

// assumptions : values are int and +ve within reasonable higher limit

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ch003AddTwoNumsLinkedList {
    public static void main(String[] args) {
//         test 1
        ListNode lnOne = new ListNode(1);
        ListNode lnTwo = new ListNode(2, lnOne);
        ListNode lnThree = new ListNode(3, lnTwo);


        System.out.println(Solution_Ch003AddTwoNumsLinkedList.len(lnOne, 0));
        System.out.println(Solution_Ch003AddTwoNumsLinkedList.len(lnTwo, 0));
        System.out.println(Solution_Ch003AddTwoNumsLinkedList.len(lnThree, 0));

        // test 2
        System.out.println(Solution_Ch003AddTwoNumsLinkedList.getNumber(lnThree, 0, 1));
        System.out.println(Solution_Ch003AddTwoNumsLinkedList.len(9877));

        // test 3
        ListNode ln987 = Solution_Ch003AddTwoNumsLinkedList.getListNode(987);
        System.out.println(Solution_Ch003AddTwoNumsLinkedList.getNumber(ln987, 0, 1));

        // final test
        var lnFinalTest = Solution_Ch003AddTwoNumsLinkedList.addTwoNumbers(ln987, lnThree);
        System.out.println(Solution_Ch003AddTwoNumsLinkedList.getNumber(lnFinalTest, 0, 1));


        // other neg test 1
        ListNode lnZre = new ListNode(0);
        ListNode lnZrf = new ListNode(0);
        var lnFinalTest2 = Solution_Ch003AddTwoNumsLinkedList.addTwoNumbers(lnZre, lnZrf);
        System.out.println(Solution_Ch003AddTwoNumsLinkedList.getNumber(lnFinalTest2, 0, 1));

        // other test 9  & 99991
        ListNode ln9 = Solution_Ch003AddTwoNumsLinkedList.getListNode(9);
        ListNode ln99991 = Solution_Ch003AddTwoNumsLinkedList.getListNode(99991);
        var lnFinalTest3 = Solution_Ch003AddTwoNumsLinkedList.addTwoNumbers(ln9, ln99991);
        System.out.println(Solution_Ch003AddTwoNumsLinkedList.getNumber(lnFinalTest3, 0, 1));
    }
}


class Solution_Ch003AddTwoNumsLinkedList {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int numL1 = getNumber(l1, 0, 1);
        int numL2 = getNumber(l2, 0, 1);
        int sumd = numL1 + numL2;
        return getListNode(sumd);
    }

    public static ListNode getListNode(int number) {
        var numberAbs = number < 0 ? number * -1 : number;
        if (len(number) == 1) return new ListNode(number);

        ListNode lnFinal = null;
        ListNode lnCurr = null;
        while (numberAbs > 0) {

            int remainder = numberAbs % 10;
            if (lnFinal == null) {
                lnFinal = new ListNode(remainder);
            } else if (lnCurr == null) {
                lnCurr = new ListNode(remainder);
                lnFinal.next = lnCurr;
            } else {
                lnCurr.next = new ListNode(remainder);
                lnCurr = lnCurr.next;
            }
            numberAbs = numberAbs / 10;
        }
        return lnFinal;
    }

    public static long len(ListNode l3, int acc) {
        if (l3 == null) return 0;
        if (l3.next == null) return acc + 1;
        else return len(l3.next, acc + 1);
    }

    public static int len(int num) {
        if (num == 0) return 1;
        int numAbs = num < 0 ? num * -1 : num;
        int length = 0;
        int tmp = 1;
        while (tmp <= numAbs) {
            length++;
            tmp = tmp * 10;
        }
        return length;
    }


    public static int getNumber(ListNode l1, int acc, int mult) {
        if (l1.next == null) return acc + l1.val * mult;
        return getNumber(l1.next, acc + l1.val * mult, mult * 10);
    }

}

// this from leet code : Definition for singly-linked list.
// @formatter:off
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
// @formatter:on

