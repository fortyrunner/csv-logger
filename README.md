csv-logger
==========

Demonstrates a stupidly simply technique for creating time logged CSV files.

How many times have you wanted to do some simple logging of statistics? Do you end up in a mess of OutputStreams exception handling or maybe you end up writing utility classes to do it.

Well... This is such a utility class.

We create a LOG4J logger (other logging frameworks are available) that logs to a CSV file (rather than the traditional log file) and then simply use log.info etc.

You can tweak the Log4J config as much as you like, time and size based roll, different date formats etc

That's it!

NOTE: This project has been converted to use [Log4J 2.x](http://logging.apache.org/log4j/2.x/), to use version 1 - simply pull an older version
