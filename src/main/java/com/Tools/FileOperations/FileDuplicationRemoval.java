package com.Tools.FileOperations;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.Tools.FileOperations.FileUtils.*;

/**
 * Created by yanli on 9/15/2016.
 */
public class FileDuplicationRemoval {
    private static final Logger logger = LoggerFactory.getLogger(FileDuplicationRemoval.class);
    private static final boolean isDeleting = false;

    public static void main(String[] arg) {
        testRemoveDuplicateFile();
    }

    private static void testRemoveDuplicateFile() {
        String pathname = "D:\\abc";
        logger.info("{}", printDuplicateFile(pathname));
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

    static int printFile(String pathname) {
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

    static int printDuplicateFile(String pathname) {
        Preconditions.checkArgument(pathname != null);
        Preconditions.checkArgument(StringUtils.isNotBlank(pathname));

        List<File> fileList = getFileList(pathname);
        Collections.sort(fileList);
        logger.info("fileList.size() = {}", fileList.size());
        HashMap<String, List<File>> map = new HashMap<String, List<File>>();
        int counter = 0;
        for (File currentFile : fileList) {
            String md5 = fileToMd5(currentFile);
            String sha1 = fileToSha1(currentFile);
            String hash = md5 + sha1;
            if (map.containsKey(hash)) {
                map.get(hash).add(currentFile);
            } else {
                LinkedList<File> list = new LinkedList<File>();
                list.add(currentFile);
                map.put(hash, list);
            }
            counter++;
            logger.info("{} / {}", counter, fileList.size());
        }

        // remove none duplicate
        {
            List<String> list = new LinkedList<String>();
            for (String key : map.keySet()) {
                if (map.get(key).size() <= 1) {
                    list.add(key);
                }
            }
            for (String key : list) {
                map.remove(key);
            }
        }
        for (List<File> files : map.values()) {
            Collections.sort(files, shorterNameComparator);
        }

        // print the remaining duplicates
        System.out.println("map.values() = " + map.values());
        System.out.println("map.size() = " + map.size());

        // delete
        if (isDeleting) {
            for (List<File> files : map.values()) {
                for (int i = 1; i < files.size(); i++) {
                    if (!files.get(i).delete()) {
                        logger.info("deletion failed = {}", files.get(i).getName());
                    } else {
                        logger.info("deleted = {}", files.get(i).getName());
                    }
                }
            }
        }

        return 0;
    }
}
