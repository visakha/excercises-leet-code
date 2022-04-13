package example;
// solving for leet code: length Of Longest Substring
// below requirmeent from leet code site
// Given a string s, find the length of the longest substring without repeating characters.
//      Input: s = "abcabcbb"
//      Output: 3
//  Explanation: The answer is "abc", with the length of 3.


import java.util.Collections;
import java.util.HashMap;

public class Ch004LengthOfLongestSubstring {
    public static void main(String[] args) {
        //         test 1
        var stringInput = "abcabcbb";
        System.out.println("longest subString wihout repeat : expected 3 | actual :" + Solution_Ch004LengthOfLongestSubstring.lengthOfLongestSubstring(stringInput));

        //         test 2
        stringInput = "xyz abcd  mno hhjjuu";
        System.out.println("longest subString wihout repeat : expected 8 | actual :" + Solution_Ch004LengthOfLongestSubstring.lengthOfLongestSubstring(stringInput)); //         test 2

        stringInput = "x";
        System.out.println("longest subString wihout repeat : expected 1 | actual :" + Solution_Ch004LengthOfLongestSubstring.lengthOfLongestSubstring(stringInput));

        stringInput = "x c";
        System.out.println("longest subString wihout repeat : expected 3 | actual :" + Solution_Ch004LengthOfLongestSubstring.lengthOfLongestSubstring(stringInput));

    }
}


class Solution_Ch004LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String inputStr) {
        if (inputStr == null) return 0;
        if (inputStr.length() == 1) return 1;

        var colltdMap = new HashMap<String, Integer>();
        int res = len(inputStr, 0, 1, "", colltdMap);
        var res2 = Collections.max( colltdMap.values());
        return res2;
    }

    private static int len(String s, int pos, int prevLen, String collectdStr, HashMap<String, Integer> collectdMap) {
        if (pos > (s.length() - 1)) {
            collectdMap.put(collectdStr, collectdStr.length());
            return prevLen;
        }
        if (collectdStr.contains(s.charAt(pos) + "")) {
            collectdMap.put(collectdStr, collectdStr.length());
            return len(s, pos + 1, 1, "", collectdMap);
        }
        else {
            return len(s, pos + 1, prevLen + 1, collectdStr + s.charAt(pos), collectdMap);
        }
    }
}

