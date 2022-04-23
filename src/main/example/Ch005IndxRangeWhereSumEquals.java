package example;
// solving for random youtube video interview QnA
// Given an array inpArray, find the index range example (3,7) where its sum equals Given num
//  inpArray[3] + inpArray[4] + inpArray[5] + inpArray[6] + inpArray[7] = Given Num


import java.util.List;

public class Ch005IndxRangeWhereSumEquals {
    public static void main(String[] args) {
        //         test 1
        var inpArray = new int[]{2, 7, 11, 9, 5, 4, 15, 9, 10};
        //index pos             {0, 1, 2,  3, 4, 5,  6, 7, 8};
        System.out.println("index range when Sum = 18 : expected (1,2) | actual :" + findIndxRange(inpArray, 18));
        System.out.println("index range when Sum = 19 : expected (1,2) | actual :" + findIndxRange(inpArray, 19));
        System.out.println("index range when Sum = 1 : expected (-1,-1) | actual :" + findIndxRange(inpArray, 1));
        System.out.println("index range when Sum = 25 : expected (2,4) | actual :" + findIndxRange(inpArray, 25));
        System.out.println("index range when Sum = 24 : expected (4,6) | actual :" + findIndxRange(inpArray, 24));
        System.out.println("index range when Sum = 124 : expected (-1,-1) | actual :" + findIndxRange(inpArray, 124));
    }

    // SOLUTION
    record Pair(int a, int b) {
    }

    public static Pair findIndxRange(int[] inpArry, int givenNum) {
        List<Integer> listOfInt = MyUtils.toListInt(inpArry);
        var soln = findIndxRange(listOfInt, givenNum);

        System.out.println("---------------------\n\n\n");
        System.out.println("found soln : " + soln + " -- for sum=" + givenNum);
        if (soln.a != -1 && soln.b != -1) {
            listOfInt.subList(soln.a, soln.b + 1).forEach(System.out::println);
        } else
            System.out.println("no soln found returning (-1,-1)");
        return soln;
    }

    public static Pair findIndxRange(List<Integer> listOfInt, int givenNum) {
        if (listOfInt == null) return new Pair(-1, -1);
        if (listOfInt.size() == 1) return new Pair(-1, -1);
        return findIndxRange(listOfInt, givenNum, new Pair(0, 1));
    }

    private static Pair findIndxRange(List<Integer> listOfInt, int givenNum, Pair pair) {
        if (pair.a == listOfInt.size() - 1) return new Pair(-1, -1);
        if (pair.b == listOfInt.size() - 1) return new Pair(-1, -1);
        int sum = listOfInt.subList(pair.a, pair.b).stream().mapToInt(e -> e).sum();

        if (sum == givenNum) return new Pair(pair.a, pair.b - 1);

        if (sum > givenNum) return findIndxRange(listOfInt, givenNum, new Pair(pair.a + 1, pair.a + 2));

        return findIndxRange(listOfInt, givenNum, new Pair(pair.a, pair.b + 1));

    }


}


