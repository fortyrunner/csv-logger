package fortyrunner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LogAsCSVTest {

  @Test
  void pop() {

    LogAsCSV.push("A,B,C");
    assertTrue(LogAsCSV.pop());
    assertFalse(LogAsCSV.pop());

  }

}