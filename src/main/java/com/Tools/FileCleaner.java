package com.Tools;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/15/2016.
 */
public class FileCleaner {
    private final static Logger logger = LoggerFactory.getLogger(FileCleaner.class);

    public static void main(String[] arg) {
        testRemoveDuplicateFile();
    }

    private static void testRemoveDuplicateFile() {
        String pathname = "D:\\abc";
        logger.info("{}", removeDuplicateFile(pathname));
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

    static int removeDuplicateFile(String pathname) {
        Preconditions.checkArgument(pathname != null);
        Preconditions.checkArgument(StringUtils.isNotBlank(pathname));

        List<File> fileList = getFileList(pathname);
        Collections.sort(fileList);
        for (File file : fileList) {
            System.out.println(file);
        }
        logger.info("fileList.size() = {}", fileList.size());

        return 0;
    }

    static int deleteFilesSet(Set<File> fileSet) {
        for (File file : fileSet) {
            if (!file.delete()) {
                logger.info("deletion failed for: file.getName() = {}", file.getName());
            }
        }

        return 0;
    }
}
