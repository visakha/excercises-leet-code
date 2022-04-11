# About
I have a leet code subscription, this is a place for notes and learnings to remember and share 

# What are the approaches
Most examples and the approach towards solving the leet code challenges emphasis memory and in-place edits over 
 - code readability
 - immutability
 - functional programming

at least when using java.

This is an attempt to solve the leet code challenges with readbility and functional thinking as an approach 

# Chapters
## 1. Implement a data structure that mimics stack with one added functionality : getMin() returna the minimum of the stored value.
requirement: getMin should have a cost of O(1)
link to code see [Stack Like](src/main/example/Ch001StackLike.java)

## 2. https://leetcode.com/problems/two-sum/
requirement: 
  - given an array get the indexes who sum of values equals target
  - O(n sqrd) at the most

solution: 
 see Ch002-two-sum
 
Observation:
 the leet code approach uses Array directly, here I am using java streams approach on ArrayList

todo next
https://leetcode.com/problems/3sum/
