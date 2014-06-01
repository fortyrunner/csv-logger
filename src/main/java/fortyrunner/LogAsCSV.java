package fortyrunner;

import com.google.common.base.Joiner;
import org.apache.log4j.Logger;

/**
 * Utility class that takes a variable length set of arguments and writes as
 * CSV to a file (that ends with CSV)
 */
public final class LogAsCSV {

  private static final Logger LOGGER = Logger.getLogger("time-taken");

  private LogAsCSV(){
  }

  public static void log(final Object... args){
    LOGGER.info(Joiner.on(',').join(args));

  }

}
