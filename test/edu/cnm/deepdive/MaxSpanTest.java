package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class MaxSpanTest {

  static final Pattern DELIMITER = Pattern.compile("\\s*,\\s*");

//  public static final int[][] INPUT = {{1, 2, 1, 1, 3}, {1, 4, 2, 1, 4, 1, 4},
//      {1, 4, 2, 1, 4, 4, 4},
//      {3, 3, 3}, {3, 9, 3}, {3, 9, 9}, {3, 9}, {3, 3}, {}, {1}};
//
//  public static final int[] EXPECTED = {4, 6, 6, 3, 3, 2, 1, 2, 0, 1};

  @ParameterizedTest
  @CsvFileSource(resources = "test.csv")
  void maxSpan(String joinedInput, int expected) {
    int[] input = DELIMITER.splitAsStream(joinedInput)
        .filter(s -> s!=null && !s.isEmpty())
        .mapToInt(s -> Integer.parseInt(s))
        .toArray();
    int actual = MaxSpan.maxSpan(input);
    assertEquals(expected, actual);

  }
}