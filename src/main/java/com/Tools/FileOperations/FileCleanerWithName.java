package com.Tools.FileOperations;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.List;

import static com.Tools.FileOperations.FileUtils.getFileList;

/**
 * Author: Oliver
 */
@Slf4j
public class FileCleanerWithName {
  public static void main(String[] arg) {
    testRemoveDuplicateFile();
  }

  private static void testRemoveDuplicateFile() {
    String pathname = "D:\\abc";
    log.info("{}", removeDuplicateFile(pathname));
  }

  private static FilenameFilter filenameFilter = new FilenameFilter() {
    public boolean accept(File dir, String name) {
      if (name.toLowerCase().endsWith(")")) {
        return true;
      } else {
        return false;
      }
    }
  };

  static int removeDuplicateFile(String pathname) {
    Preconditions.checkArgument(pathname != null);
    Preconditions.checkArgument(StringUtils.isNotBlank(pathname));

    List<File> fileList = getFileList(pathname);
    Collections.sort(fileList);
    for (File file : fileList) {
      log.debug("file={}", file);
    }
    log.info("fileList.size() = {}", fileList.size());

    return 0;
  }
}
