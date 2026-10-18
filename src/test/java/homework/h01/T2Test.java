package homework.h01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class T2Test {

  private final T2 solution = new T2();

  @Test
  void countsOddsForTheExampleRange() {
    assertThat(solution.countOdds(3, 7)).isEqualTo(3);
  }

  @Test
  void countsAOneElementOddRange() {
    assertThat(solution.countOdds(7, 7)).isOne();
  }

  @Test
  void countsAOneElementEvenRange() {
    assertThat(solution.countOdds(8, 8)).isZero();
  }
}
