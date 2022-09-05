package com.Tools.FileOperations;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Author: Oliver
 */
@Slf4j
public class FileUtils {
  public static void main(String[] arg) {
    testFileUtils();
  }

  private static void testFileUtils() {
    log.info("{}", fileUtils());
  }

  static int fileUtils() {
    return 0;
  }

  static List<File> getFileList(String pathname) {
    Preconditions.checkArgument(pathname != null);
    Preconditions.checkArgument(StringUtils.isNotBlank(pathname));

    List<File> fileList = new LinkedList<File>();
    File rootFile = new File(pathname);
    Queue<File> queue = new LinkedList<File>();
    queue.add(rootFile);
    while (!queue.isEmpty()) {
      File currentFile = queue.poll();
      if (currentFile.exists()) {
        if (currentFile.isDirectory()) {
          File[] files = currentFile.listFiles();
          if (files != null) {
            queue.addAll(Arrays.asList(files));
          }
        } else {
          fileList.add(currentFile);
        }
      }
    }

    return fileList;
  }

  static int deleteFilesSet(Set<File> fileSet) {
    for (File file : fileSet) {
      if (!file.delete()) {
        log.info("deletion failed for: file.getName() = {}", file.getName());
      }
    }

    return 0;
  }

  static String fileToMd5(File file) {
    long startTime = System.currentTimeMillis();
    FileInputStream fis;
    String md5 = "";
    try {
      fis = new FileInputStream(file);
      md5 = DigestUtils.md5Hex(fis);
      fis.close();
    } catch (IOException e) {
      log.error(e.getMessage());
    }

    log.info("fileToMd5() time taken = {} s", (System.currentTimeMillis() - startTime) / 1000.0);
    return md5;
  }

  static String fileToSha512(File file) {
    long startTime = System.currentTimeMillis();
    FileInputStream fis;
    String sha512 = "";
    try {
      fis = new FileInputStream(file);
      sha512 = DigestUtils.sha512Hex(fis);
      fis.close();
    } catch (IOException e) {
      log.error(e.getMessage());
    }

    log.info("fileToSha1() time taken = {} s", (System.currentTimeMillis() - startTime) / 1000.0);
    return sha512;
  }

  static Comparator<File> shorterNameComparator = new Comparator<File>() {
    public int compare(File o1, File o2) {
      return o1.getName().length() - o2.getName().length();
    }
  };
}
