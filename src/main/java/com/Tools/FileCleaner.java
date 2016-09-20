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

    static Set<File> getFileSet(String pathname) {
        Preconditions.checkArgument(pathname != null);
        Preconditions.checkArgument(StringUtils.isNotBlank(pathname));

        Set<File> fileSet = new HashSet<File>();
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
                    fileSet.add(currentFile);
                }
            }
        }

        return fileSet;
    }

    static int removeDuplicateFile(String pathname) {
        Preconditions.checkArgument(pathname != null);
        Preconditions.checkArgument(StringUtils.isNotBlank(pathname));

        Set<File> fileSet = getFileSet(pathname);
        for (File file : fileSet) {
            System.out.println(file);
        }
        logger.info("fileSet.size() = {}", fileSet.size());

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
