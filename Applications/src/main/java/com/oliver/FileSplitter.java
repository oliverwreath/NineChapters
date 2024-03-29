package com.oliver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Author: Oliver
 */
@Slf4j
public class FileSplitter {

  public static void main(String[] args) {
    log.info("begin");
    splitFileInSameFolder(Path.of("src/main/resources/bigFile.txt"), 3);
    log.info("end");
  }

  static List<Path> splitFileInSameFolder(Path sourceFilePath, int partitions) {
    assert partitions > 0;
    long lineCount = countLineJava8(sourceFilePath);
    log.debug("lineCount={}", lineCount);
    long step = (lineCount + partitions) / partitions;
    log.debug("step={}, lineCount%partitions={}", step, lineCount % partitions);
    int r;
    for (r = 0; r < partitions; r++) {
      long begin = r * step;
      long end = Math.min(begin + step, lineCount - 1);
      log.debug("r={}, begin={} -> end={}", r, begin, end);
    }
    List<Path> chunkFiles = new ArrayList<>();
    try (BufferedReader reader = Files.newBufferedReader(sourceFilePath)) {
      for (r = 0; r < partitions; r++) {
        long begin = r * step;
        long end = Math.min(begin + step, lineCount - 1);
        Path targetPath = sourceFilePath.resolveSibling(String.valueOf(r) + sourceFilePath.getFileName());
        try (BufferedWriter writer = Files.newBufferedWriter(targetPath)) {
          readWriteChunkOfLines(reader, writer, end - begin + 1);
        }
        chunkFiles.add(targetPath);
      }
    } catch (IOException e) {
      log.error(e.getMessage());
    }
    return chunkFiles;
  }

  static void readWriteChunkOfLines(BufferedReader reader, BufferedWriter writer, long numOfLines) throws IOException {
    log.debug("numOfLines={}", numOfLines);
    for (long i = 0; i < numOfLines; i++) {
      String s = StringUtils.trimToEmpty(reader.readLine());
      if (!s.isEmpty()) {
        writer.write(s + ((i < numOfLines - 1) ? "\n" : ""));
      }
    }
  }

  public static long countLineJava8(Path filePath) {
    long lineCount = 0;
    try (var lines = Files.lines(filePath)) {
      lineCount = lines.parallel().count();
    } catch (IOException e) {
      log.error(e.getMessage());
    }
    return lineCount;
  }
}
