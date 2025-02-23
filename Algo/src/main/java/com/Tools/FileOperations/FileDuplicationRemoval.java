package com.Tools.FileOperations;

import static com.Tools.FileOperations.FileUtils.fileToMd5;
import static com.Tools.FileOperations.FileUtils.fileToSha512;
import static com.Tools.FileOperations.FileUtils.getFileList;
import static com.Tools.FileOperations.FileUtils.shorterNameComparator;

import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Author: Oliver
 */
@Slf4j
public class FileDuplicationRemoval {

  private static final boolean IS_DELETING = false;

  public static void main(String[] arg) {
    testRemoveDuplicateFile();
  }

  private static void testRemoveDuplicateFile() {
    String pathname = "D:\\abc";
    log.info("{}", printDuplicateFile(pathname));
  }

  private static FilenameFilter filenameFilter = (dir, name) -> name.toLowerCase().endsWith(")");

  static int printFile(String pathname) {
    Preconditions.checkArgument(pathname != null);
    Preconditions.checkArgument(StringUtils.isNotBlank(pathname));

    List<File> fileList = getFileList(pathname);
    Collections.sort(fileList);
    for (File file : fileList) {
      log.info(String.valueOf(file));
    }
    log.info("fileList.size() = {}", fileList.size());

    return 0;
  }

  static int printDuplicateFile(String pathname) {
    Preconditions.checkArgument(pathname != null);
    Preconditions.checkArgument(StringUtils.isNotBlank(pathname));

    List<File> fileList = getFileList(pathname);
    Collections.sort(fileList);
    log.info("fileList.size() = {}", fileList.size());
    HashMap<String, List<File>> map = new HashMap<>();
    int counter = 0;
    for (File currentFile : fileList) {
      String hash = getHashing(currentFile);
      if (map.containsKey(hash)) {
        map.get(hash).add(currentFile);
      } else {
        LinkedList<File> list = new LinkedList<>();
        list.add(currentFile);
        map.put(hash, list);
      }
      counter++;
      log.info("{} / {}", counter, fileList.size());
    }

    // remove none duplicate
    removeNoneDuplicate(map);
    for (List<File> files : map.values()) {
      Collections.sort(files, shorterNameComparator);
    }

    // print the remaining duplicates
    log.info("map.values() = " + map.values());
    log.info("map.size() = " + map.size());

    // delete
    if (IS_DELETING) {
      for (List<File> files : map.values()) {
        for (int i = 1; i < files.size(); i++) {
//                    Files.delete(files.get(i));
          if (!files.get(i).delete()) {
            log.info("deletion failed = {}", files.get(i).getName());
          } else {
            log.info("deleted = {}", files.get(i).getName());
          }
        }
      }
    }

    return 0;
  }

  private static void removeNoneDuplicate(HashMap<String, List<File>> map) {
    List<String> list = new LinkedList<>();
    for (Map.Entry<String, List<File>> entry : map.entrySet()) {
      if (entry.getValue().size() <= 1) {
        list.add(entry.getKey());
      }
    }
    for (String key : list) {
      map.remove(key);
    }
  }

  private static String getHashing(File currentFile) {
    String md5 = fileToMd5(currentFile);
    String sha512 = fileToSha512(currentFile);
    return md5 + sha512;
  }
}
