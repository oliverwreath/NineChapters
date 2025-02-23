package com.Inf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

/**
 * Author: Oliver
 * <p>
 * Input： a huge file with n words (Assumption: n > 100k) Output： Distinct Words in Ascending order (Assumption: We only
 * need alphaDigit words, so remove special characters like , " ' etc...).
 * <p>
 * <p>
 * When all we have is ONE-Small-machine, we are using the sequential I/O so we need some algorithms good for sequential
 * access (like 2-pointers algorithms for merging 2 sorted arrays in linear time/ one pass) and tune it up for
 * production level k-way merging. So for something HUGE, let's use Divide& Conquer methodology to figure this out!
 * <p>
 * Let's define the Chunk means 15G of input data (Assumption: Memory 16G) with n words. Time complexity O(n) for
 * deduplicating one chunk. Time complexity O(n log n) for sorting one chunk. So the bottleneck lies in the sorting.
 * <p>
 * 1st Pass. Very efficient - linear Time Complexity: O(n) - break down into small chunks that fits the memory - linear
 * Space Complexity: O(n). 2nd Pass. Sort each chunk individually. 3rd Pass. Time Complexity: O(n) n is the total number
 * of words; Combine them easily, like, k-way merge at the same time like the 2-pointer algorithms trick, we just need a
 * pointer for every chunk and a get the smallest among them, append to the output, rinse and repeat. (hint Oliver: be
 * careful about deduplicating. This can be a Gotcha moment!)
 * <p>
 * Bonus point/ Optimization for highest standard: 1. Use a good quicksort implementation that can switch to selection
 * sort when the task becomes small. 2. We can ask follow up for TopK and see if he can use minimum heap or TopK
 * algorithms to stand out.
 * <p>
 * <p>
 * Digress: If we can use Big data infrastructures, 1. MapReduce mapper can use a hashSet deduplicating, then reducer
 * can sort.
 */
@Slf4j
public class HugeFileSorting {

  private static final String HUGE_FILE_PATH = "C:\\Users\\yanli\\IdeaProjects\\JiuZhang\\src\\main\\java\\com\\Inf\\inputHuge.txt";
  private static final String OUTPUT_FOLDER_PATH = "C:\\Users\\yanli\\IdeaProjects\\JiuZhang\\src\\main\\java\\com\\Inf\\output";
  private static final String FINAL_OUTPUT_PATH = "C:\\Users\\yanli\\IdeaProjects\\JiuZhang\\src\\main\\java\\com\\Inf\\output\\FINAL_Sorted_Words.txt";
  private static final Long SIZE_THAT_FITS_MEMORY = 100L;
  private static final String FILE_SUFFIX = ".txt";

  /**
   * Step #1 - 1st Pass - break down into small chunks that fits the memory
   *
   * @param HUGE_FILE_PATH        source of our data (words)
   * @param OUTPUT_FOLDER_PATH    folder to write intermediate data (results)
   * @param SIZE_THAT_FITS_MEMORY the appropriate size of your choice (by number of distinct words)
   * @return list of small chunks' fileNames e.g. chunk1.txt, chunk2.txt, chunk3.txt
   */
  public static List<String> hugeFile2SmallFiles(final String HUGE_FILE_PATH, final String OUTPUT_FOLDER_PATH,
      final long SIZE_THAT_FITS_MEMORY) {
    // filter abnormal cases
    if (isNullOrEmpty(HUGE_FILE_PATH) || isNullOrEmpty(OUTPUT_FOLDER_PATH) || SIZE_THAT_FITS_MEMORY < 1) {
      return new LinkedList<>();
    }
    try {
      FileUtils.deleteDirectory(new File(OUTPUT_FOLDER_PATH));
    } catch (IOException e) {
      log.error(e.getMessage());
    }
    createFolderIfNotExists(OUTPUT_FOLDER_PATH);

    // main logic
    HashSet<String> hashSet = new HashSet<>();
    int fileNumber = 0;
    List<String> smallFiles = new LinkedList<>();
    final String hugeFileName = HUGE_FILE_PATH.substring(HUGE_FILE_PATH.lastIndexOf('\\'),
        HUGE_FILE_PATH.lastIndexOf('.'));
    try (BufferedReader bf = new BufferedReader(new FileReader(new File(HUGE_FILE_PATH)))) {
      // for Every File
      String line;
      while ((line = bf.readLine()) != null) {
        if (line.isEmpty()) {
          continue;
        }

        for (String word : line.split(" ", -1)) {
          // for Every Word
          String tmpWord = trimNonAlphaDigit(word);
          if (isNullOrEmpty(tmpWord) || hashSet.contains(tmpWord)) {
            continue;
          }

          hashSet.add(tmpWord);
          if (hashSet.size() >= SIZE_THAT_FITS_MEMORY) {
            // Enough to write and flush to a chunk file (file that fits the memory (size configurable)).
            String smallFileName = writeWords2File(sortWords(hashSet),
                OUTPUT_FOLDER_PATH + hugeFileName + "_chunk_" + fileNumber++ + FILE_SUFFIX);
            smallFiles.add(smallFileName);
            hashSet = new HashSet<>();
          }
        }
      }

      if (hashSet.size() > 0) {
        // Don't forget the remaining words, write and flush to a chunk file.
        String smallFileName = writeWords2File(hashSet,
            OUTPUT_FOLDER_PATH + hugeFileName + "_chunk_" + fileNumber + FILE_SUFFIX);
        smallFiles.add(smallFileName);
      }
    } catch (IOException e) {
      log.error(e.getMessage());
    }

    return smallFiles;
  }

  /**
   * helper function - helping step 1& 3 by persisting the words into a file of your choice.
   *
   * @param iterableCollection     words to persist
   * @param FILE_NAME_OF_ONE_CHUNK where to persist
   * @return where the data (words) is persisted
   * @throws IOException
   */
  private static String writeWords2File(Iterable<String> iterableCollection, String FILE_NAME_OF_ONE_CHUNK)
      throws IOException {
    File file = new File(FILE_NAME_OF_ONE_CHUNK);
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
      for (String s : iterableCollection) {
        bw.write(s);
        bw.newLine();
      }
      bw.flush();
    }
    return FILE_NAME_OF_ONE_CHUNK;
  }

  /**
   * Step #2 - Sort the words.
   *
   * @param hashSet unsorted words.
   * @return sorted words.
   */
  private static List<String> sortWords(final HashSet<String> hashSet) {
    PriorityQueue<String> pq = new PriorityQueue<>(hashSet);

    List<String> list = new LinkedList<>();
    while (!pq.isEmpty()) {
      list.add(pq.poll());
    }
    return list;
  }

  /**
   * Step #3 - 3rd Pass - k-way merging efficiently (mimicking classic trick "merging 2 sorted arrays")
   *
   * @param smallFiles        a list of k smallFiles (chunks)
   * @param FINAL_OUTPUT_PATH the final output file (k-way merged file (with deduplication))
   */
  public static void kWayMerging(final List<String> smallFiles, final String FINAL_OUTPUT_PATH) {
    // filter abnormal inputs
    if (smallFiles == null || smallFiles.size() == 0 || isNullOrEmpty(FINAL_OUTPUT_PATH)) {
      return;
    }

    // main logic - k-way merging (by the way handling duplications)
    List<Scanner> scannerList = new ArrayList<>();
    populateScannerList(smallFiles, scannerList);

    // first round populate the empty PriorityQueue
    PriorityQueue<Entry> pq = new PriorityQueue<>((o1, o2) -> o1.word.compareTo(o2.word));
    List<Scanner> exhaustedScannersPendingRemoval = new LinkedList<>();
    for (int i = 0; i < scannerList.size(); i++) {
      if (!scannerList.get(i).hasNext()) {
        exhaustedScannersPendingRemoval.add(scannerList.get(i));
        continue;
      }

      pq.add(new Entry(scannerList.get(i).next(), i));
    }
    scannerList.removeAll(exhaustedScannersPendingRemoval);

    // in a loop keep exhausted every source in a k-way merging style
    while (!scannerList.isEmpty()) {
      Entry nextEntry = pq.poll();

    }

  }

  private static void populateScannerList(List<String> smallFiles, List<Scanner> scannerList) {
    for (String oneFile : smallFiles) {
      Scanner scanner = new Scanner(oneFile);
      scannerList.add(scanner);
    }
  }

  private static void populateBrList(List<String> smallFiles, List<BufferedReader> brList) {
    for (String oneFile : smallFiles) {
      BufferedReader br = null;
      try {
        br = getBufferedReaderForFile(oneFile);
      } catch (FileNotFoundException e) {
        log.error(e.getMessage());
      }
      if (null != br) {
        brList.add(br);
      }
    }
  }

  static class Entry {

    String word;
    int index;

    public Entry(String word, int index) {
      this.word = word;
      this.index = index;
    }

    @Override
    public String toString() {
      return "Entry{" +
          "word='" + word + '\'' +
          ", index=" + index +
          '}';
    }
  }

  /**
   * helper functions that prints intermediate results beautifully.
   *
   * @param smallFiles
   * @param topK
   */
  private static void printSmallFiles(final List<String> smallFiles, final int topK) {
    log.info("smallFiles = {}", smallFiles + "\n");
    long totalCount = 0;
    for (String filePath : smallFiles) {
      log.info("filePath = {}", filePath);
      int counter = 0;
      try (BufferedReader bf = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = bf.readLine()) != null) {
          if (!line.isEmpty()) {
            if (!isNullOrEmpty(line)) {
              if (counter < topK) {
                log.info("{}", line);
              }
              counter++;
//                            else {
//                                break;
//                            }
            }
          }
        }
      } catch (IOException e) {
        log.error(e.getMessage());
      }
      totalCount += counter;
      log.info("counter = {}", counter + "\n");
    }
    log.info("totalCountOfAllFiles = {}", totalCount + "\n");
  }

  private static BufferedReader getBufferedReaderForFile(String filePath) throws FileNotFoundException {
    return new BufferedReader(new FileReader(filePath));
  }

  private static boolean isNullOrEmpty(final String inputString) {
    return inputString == null || "".equals(inputString);
  }

  private static String trimNonAlphaDigit(final String inputString) {
    return inputString.replaceAll("[^\\p{IsAlphabetic}^\\p{IsDigit}]", "");
  }

  private static void createFolderIfNotExists(final String OUTPUT_FOLDER_PATH) {
    boolean succededMkdirs = new File(OUTPUT_FOLDER_PATH).mkdirs();
    log.debug("succededMkdirs = {}", succededMkdirs);
  }

  private static void step1Test() {
    List<String> smallFiles = hugeFile2SmallFiles(HUGE_FILE_PATH, OUTPUT_FOLDER_PATH, SIZE_THAT_FITS_MEMORY);
    printSmallFiles(smallFiles, 5);
  }

  private static void step123Test() {
    List<String> smallFiles = hugeFile2SmallFiles(HUGE_FILE_PATH, OUTPUT_FOLDER_PATH, SIZE_THAT_FITS_MEMORY);
    printSmallFiles(smallFiles, 5);

    kWayMerging(smallFiles, FINAL_OUTPUT_PATH);
  }

  public static void main(String[] args) {
//        step1Test();
    step123Test();
  }
}
