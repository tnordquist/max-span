package edu.cnm.deepdive;

/*
CodingBat Problem: maxSpan
Consider the leftmost and rightmost appearances of some value in an array. We'll
say that the "span" is the number of elements between the two inclusive. A
single value has a span of 1. Returns the largest span found in the given array.
(Efficiency is not a priority.)
 */

public class MaxSpan {

  public static int maxSpan(int[] nums) {
    int count;
    int currentNum;
    int span;
    int maxSpan = 0;

    for (int i = 0; i < nums.length; ++i) {
      currentNum = nums[i];
      count = 0;
      span = 0;
      for (int j = i; j < nums.length; ++j) {
        count += 1;
        if (currentNum == nums[j]) {
          span += count;
          count = 0;
        }
      }
      if (span >= maxSpan) {
        maxSpan = span;
      }
    }
    return maxSpan;
  }
}