package fortyrunner;

import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * Utility class that takes a variable length set of arguments and writes as
 * CSV to a file (that ends with CSV).
 *
 * Note that you don't have to use Guava to join the objects to a CSV string it
 * is possible to use Java 8 Strings.join - this is a bit fiddlier though for an
 * object array.
 */
public final class LogAsCSV implements AutoCloseable {

  private static final Deque<TimedMessage> messageStack = new ArrayDeque<>();

  private static final Logger LOGGER = LoggerFactory.getLogger("time-taken");

  private LogAsCSV(){

  }

  public static void log(final Object... args){
    LOGGER.info(Joiner.on(',').join(args));
  }


  public static void push(final Object... args){
    String joined = Joiner.on(',').join(args);
    LOGGER.info(joined+",STARTS,0");
    messageStack.push(new TimedMessage(joined));
  }

  public static boolean pop(){
    if (messageStack.isEmpty()){
      return false;
    }
    TimedMessage message = messageStack.pop();
    LOGGER.info(message.getMessage()+",ENDS,"+message.timeTaken());
    return true;
  }

  @Override
  public void close() throws IOException {
    pop();
  }

  private static class TimedMessage {
    private final String message;
    private final long startTime = System.currentTimeMillis();

    TimedMessage(final String message) {
      this.message = message;
    }

    private String getMessage() {
      return message;
    }

    private long timeTaken() {
      return System.currentTimeMillis() - startTime;
    }

    @Override
    public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      TimedMessage that = (TimedMessage) o;
      return startTime == that.startTime &&
        Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
      return Objects.hash(message, startTime);
    }
  }

}
