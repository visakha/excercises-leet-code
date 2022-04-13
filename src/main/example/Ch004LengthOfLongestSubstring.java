package example;
// solving for leet code: length Of Longest Substring
// below requirmeent from leet code site
// Given a string s, find the length of the longest substring without repeating characters.
//      Input: s = "abcabcbb"
//      Output: 3
//  Explanation: The answer is "abc", with the length of 3.


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Ch004LengthOfLongestSubstring {
    public static void main(String[] args) {
        //         test 1
        var stringInput = "abcabcbb";
        System.out.println("working on |" + stringInput + "|" );
        System.out.println("longest subString wihout repeat : expected 3 | actual :" + Solution_Ch004LengthOfLongestSubstring.lengthOfLongestSubstring(stringInput));

        //         test 2
        stringInput = "xyz abcd  mno hhjjuu";
        System.out.println("working on |" + stringInput + "|" );
        System.out.println("longest subString wihout repeat : expected 8 | actual :" + Solution_Ch004LengthOfLongestSubstring.lengthOfLongestSubstring(stringInput)); //         test 2

        stringInput = "x";        System.out.println("working on |" + stringInput + "|" );
        System.out.println("longest subString wihout repeat : expected 1 | actual :" + Solution_Ch004LengthOfLongestSubstring.lengthOfLongestSubstring(stringInput));

        stringInput = "x c";        System.out.println("working on |" + stringInput + "|" );
        System.out.println("longest subString wihout repeat : expected 3 | actual :" + Solution_Ch004LengthOfLongestSubstring.lengthOfLongestSubstring(stringInput));

        stringInput = "aab";        System.out.println("working on |" + stringInput + "|" );
        System.out.println("longest subString wihout repeat : expected 2 | actual :" + Solution_Ch004LengthOfLongestSubstring.lengthOfLongestSubstring(stringInput));

        stringInput = "dvdf";        System.out.println("working on |" + stringInput + "|" );
        System.out.println("longest subString wihout repeat : expected 3 | actual :" + Solution_Ch004LengthOfLongestSubstring.lengthOfLongestSubstring(stringInput));

//
    }
}


class Solution_Ch004LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() == 1) return 1;

        var colltdMap = new ArrayList<String>();
        len(s, 0, "",  colltdMap);
        return Collections.max( colltdMap.stream().map(String::length).toList());
    }

    private static void len(String s, int pos, String collectdStr, List<String> collectdMap) {
        if (pos > (s.length() - 1)) {
            collectdMap.add(collectdStr);
            return ;
        }
        if (collectdStr.contains(s.charAt(pos) + "")) {
            collectdMap.add(collectdStr);
            len(s, collectdMap.size(),   "", collectdMap);
        }
        else {
            len(s, pos + 1,  collectdStr + s.charAt(pos), collectdMap);
        }
    }
}

