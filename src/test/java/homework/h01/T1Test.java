package homework.h01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class T1Test {

  private final T1 solution = new T1();

  @Test
  void returnsTheNumberForAnEvenInput() {
    assertThat(solution.smallestEvenMultiple(6)).isEqualTo(6);
  }

  @Test
  void doublesAnOddInput() {
    assertThat(solution.smallestEvenMultiple(5)).isEqualTo(10);
  }
}
