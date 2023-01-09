package com.oliver;

import static com.oliver.FileSplitter.countLineJava8;
import static com.oliver.FileSplitter.splitFileInSameFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Author: Oliver
 */
@Slf4j
class FileSplitterTest {

  @Test void testReadCards() {
    long lineJava8 = countLineJava8(Path.of("src/test/resources/TestFile.txt"));
    Assertions.assertEquals(5, lineJava8);
  }

  @Test void testSplitFileInSameFolder() throws IOException {
    for (int i = 1; i < 8; i++) {
      List<Path> chunkFiles = splitFileInSameFolder(Path.of("src/test/resources/TestFile.txt"), i);
      Assertions.assertEquals(i, chunkFiles.size());
      for (Path chunkFile : chunkFiles) {
        Files.deleteIfExists(chunkFile);
      }
    }
  }
}
