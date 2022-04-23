package example;
// solving for random youtube video interview QnA
// Given an array inpArray, find the index range example (3,7) where its sum equals Given num
//  inpArray[3] + inpArray[4] + inpArray[5] + inpArray[6] + inpArray[7] = Given Num


import java.util.List;

public class Ch006BestTimeBuySellStock {
    public static void main(String[] args) {
        var inpArray = new int[]{7, 1, 5, 3, 6, 4};
        //index pos             {0, 1, 2,  3, 4, 5};
        System.out.println("max Profit : expected 5 | actual :" + findMaxProfit(inpArray));

        inpArray = new int[]{7, 1, 15, 3, 6, 4};
        System.out.println("max Profit : expected 14 | actual :" + findMaxProfit(inpArray));

    }

    public static int findMaxProfit(int[] inpArry) {
        List<Integer> listOfInt = MyUtils.toListInt(inpArry);
        var soln = findMaxProfit(listOfInt, new P3(0, 0, 1), 0, 1);
        System.out.println("got output | profit=" + soln.profit + " |buy@ $" + listOfInt.get(soln.pos1) + " |sell@ $" + listOfInt.get(soln.pos2));
        return soln.profit;
    }

    record P3(int profit, int pos1, int pos2) {
    }

    public static P3 findMaxProfit(List<Integer> listOfInt, P3 prevProfit, int pos1, int pos2) {

        if (listOfInt == null || listOfInt.size() == 1) return new P3(0, pos1, pos2);
        var currPos1 = pos1;
        var sizeOfList = listOfInt.size();

        if (pos1 == sizeOfList - 1) return prevProfit;

        var buyPrice = listOfInt.get(pos1);
        var sellPrice = listOfInt.get(pos2);

        var currProfit = sellPrice - buyPrice;
        if (currProfit > prevProfit.profit) // sell profit only
            prevProfit = new P3(currProfit, pos1, pos2);

        if (pos2 == sizeOfList - 1) {
            pos1 = currPos1 + 1;
            pos2 = currPos1 + 2;
            return findMaxProfit(listOfInt, prevProfit, pos1, pos2);
        }

        pos2 = pos2 + 1;
        return findMaxProfit(listOfInt, prevProfit, pos1, pos2);

    }


}


