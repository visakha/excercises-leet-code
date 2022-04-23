# About
I have a leet code subscription, this is a place for notes and learnings to remember and share 

# What are the approaches
Most examples and the approach towards solving the leet code challenges emphasis memory and in-place edits over 
 - code readability
 - immutability
 - functional programming

at least when using java.

This is an attempt to solve the leet code challenges with readbility and functional thinking as an approach 

# tools
https://app.coderpad.io/sandbox


# Chapters
## 1. Implement a data structure that mimics stack with one added functionality : getMin() returna the minimum of the stored value.
requirement: getMin should have a cost of O(1)
link to code see [Stack Like](src/main/example/Ch001StackLike.java)

## 2. leetcode /problems/two-sum/
requirement: 
  - given an array get the indexes who sum of values equals target
  - O(n sqrd) at the most

solution: 
 see Ch002-two-sum
 
Observation:
 the leet code approach uses Array directly, here I am using java streams approach on ArrayList

## 3. leetcode /problems/add to nums/
requirement: 
  - see desc in the solution

solution: 
 see Ch003-Add-TwoNums-LinkedList

## 4. leetcode /problems/Length Of Longest Substring
requirement: 
  - see desc in the solution

solution: 
 see Ch004-Length-Of-Longest-Substring
 
## 5. random youtube video: find index range of an array, sum of whose values equals the given number
requirement: 

  - solving for random youtube video interview QnA
  
    Given an array inpArray, find the continous index range where its sum equals Given num
  
    example: var inpArray = new int[]{2, 7, 11, 9, 5, 4, 15, 9, 10};
  
    when Given Num = 18 : expected (1,2) because inpArray[1] + inpArray[2] = 7 + 11 = 18

solution: 
 see Ch005IndxRangeWhereSumEquals
 

## 5. best-time-to-buy-and-sell-stock
from leetCode
    https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

requirement: 
    see the link above in leetCode
    
solution: 
 see Ch006BestTimeBuySellStock
 



todo next
https://leetcode.com/problems/3sum/
