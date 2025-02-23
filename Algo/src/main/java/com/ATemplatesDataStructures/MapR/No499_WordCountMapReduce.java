import java.util.Iterator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No499_WordCountMapReduce {

  abstract class OutputCollector<K, V> {

    public abstract void collect(K key, V value);
    // Adds a key/value pair to the output buffer
  }

  public static class WordCount {

    public static class Map {

      public void map(String key, String value, OutputCollector<String, Integer> output) {

        // Output the results into output buffer.
        // Ps. output.collect(String key, int value);
        String[] words = value.split(" ", -1);
        for (String word : words) {
          output.collect(word, 1);
        }
      }
    }

    public static class Reduce {

      public void reduce(String key, Iterator<Integer> values,
          OutputCollector<String, Integer> output) {

        // Output the results into output buffer.
        // Ps. output.collect(String key, int value);
        int count = 0;
        while (values.hasNext()) {
          count += values.next();
        }
        output.collect(key, count);
      }
    }
  }

}
