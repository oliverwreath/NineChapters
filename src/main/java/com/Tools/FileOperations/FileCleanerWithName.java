package com.Tools.FileOperations;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.Tools.FileOperations.FileUtils.getFileList;

/**
 * Created by yanli on 9/15/2016.
 */
public class FileCleanerWithName {
    private final static Logger logger = LoggerFactory.getLogger(FileCleanerWithName.class);

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
}
