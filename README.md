csv-logger
==========

Demonstrates a stupidly simply technique for creating time logged CSV files.

How many times have you wanted to do some simple logging of statistics? Do you end up in a mess of OutputStreams exception handling? or maybe you end up writing utility classes to do it.

Well. This is such a utility class.

We create a LOG4J logger (other logging frameworks are available) that logs to a CSV file (rather the the traditional log file). Then simply use log.info etc.

You can tweak the Log4J config as much as you like, time and size based roll, different date formats etc

Thats it!
