package homework.h01;

/** Solution for LeetCode 2413: Smallest Even Multiple. */
public class T1 {

  public int smallestEvenMultiple(int n) {
    return n % 2 == 0 ? n : n * 2;
  }
}
