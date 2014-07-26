package fortyrunner;

public class App {


  public static void main(final String... args) {

    long starts = System.currentTimeMillis();
    String s = "";
    for (int i = 0; i < 3000; i++) {
      s += "0";
    }

    long took = System.currentTimeMillis() - starts;

    LogAsCSV.log("String length", s.length(), took);

    System.out.println("Now check time-taken.csv");

  }

}
