package fortyrunner;

import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class that takes a variable length set of arguments and writes as
 * CSV to a file (that ends with CSV).
 *
 * Note that you don't have to use Guava to join the objects to a CSV string it
 * is possible to use Java 8 Strings.join - this is a bit fiddlier though for an
 * object array.
 */
public final class LogAsCSV {

  private static final Logger LOGGER = LoggerFactory.getLogger("time-taken");

  private LogAsCSV(){

  }

  public static void log(final Object... args){
    LOGGER.info(Joiner.on(',').join(args));
  }

}
