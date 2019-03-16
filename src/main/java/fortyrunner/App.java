package fortyrunner;

import java.util.concurrent.ThreadLocalRandom;

public class App {


  public static void main(final String... args) {

    long starts = System.currentTimeMillis();
    String s = getARandomString();

    long took = System.currentTimeMillis() - starts;

    LogAsCSV.log("String length", s.length(), took);
    LogAsCSV.log("Something happened", s.length(), -1);

    System.out.println("Now check time-taken.csv");

    System.out.println("Now use an alternative way to time things");

    LogAsCSV.push("Sleeping a random time");
    waitARandomTime();
    LogAsCSV.pop();

  }

  private static void waitARandomTime() {
    try {
      long howLong = ThreadLocalRandom.current().nextLong(10_000);
      Thread.sleep(howLong);
    } catch (InterruptedException e) {
    }
  }

  private static String getARandomString() {
    String s = "";
    for (double i = 0; i < Math.random()*1_000_000; i++) {
      s += "0";
    }
    return s;
  }

}
