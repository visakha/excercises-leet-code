package example;
// solving for https://leetcode.com/problems/two-sum/
// given an array get the indexes who sum of values equals target ...
// we will use Arrays.stream( data ).boxed().toArray( Integer[]::new );
//          from https://stackoverflow.com/questions/880581/how-can-i-convert-int-to-integer-in-java/27043087#27043087

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ch002TwoSum {
    public static void main(String[] args) {
        var nums = new int[]{2, 7, 11, -9, 5, 4, 15, -9, 10};

        // test 1
        var target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println("should be 0,1 | " + printIntArray(ints));
        // test 2
        target = 11;
        ints = twoSum(nums, target);
        System.out.println("should be 1,4 | " + printIntArray(ints));

        // test 3
        target = 18;
        ints = twoSum(nums, target);
        System.out.println("should be 1, 2 | " + printIntArray(ints));
        // test 4
        target = 1;
        ints = twoSum(nums, target);
        System.out.println("should be 3, 8 | " + printIntArray(ints));


    }

    // SOLUTION
    public static int[] twoSum(int[] nums, int target) {
        List<Integer> listOfInt = Arrays.stream(nums).boxed().toList();
        return getIdx(listOfInt, target, 0);
    }

    private static int[] getIdx(List<Integer> nums, int target, int initPos) {
        if (nums.size() == initPos + 1) throw new RuntimeException("no such result can be found");
        Integer initVal = nums.get(initPos);
        int idxResult = IntStream.range(0, nums.size())
                .filter(currPos -> currPos > initPos)
                .filter(currPos -> (nums.get(currPos) + initVal) == target)
                .findAny()
                .orElseGet(() -> -1);
        if (idxResult == -1) return getIdx(nums, target, initPos + 1);
        return new int[]{initPos, idxResult};
    }

    public static String printIntArray(int[] nums) {
        return Arrays.stream(nums).boxed().toList()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
