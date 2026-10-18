package homework.h01;

/** Solution for LeetCode 1523: Count Odd Numbers in an Interval Range. */
public class T2 {

  public int countOdds(int low, int high) {
    return (high + 1) / 2 - low / 2;
  }
}
