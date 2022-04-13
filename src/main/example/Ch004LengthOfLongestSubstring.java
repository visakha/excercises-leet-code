package example;
// solving for leet code: length Of Longest Substring
// below requirmeent from leet code site
// Given a string s, find the length of the longest substring without repeating characters.
//      Input: s = "abcabcbb"
//      Output: 3
//  Explanation: The answer is "abc", with the length of 3.


public class Ch004LengthOfLongestSubstring {
    public static void main(String[] args) {
        //         test 1
        var stringInput = "abcabcbb";
        System.out.println("longest subString wihout repeat :" + Solution_Ch004LengthOfLongestSubstring.lengthOfLongestSubstring(stringInput));

    }
}


class Solution_Ch004LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        return 5;
    }
}

