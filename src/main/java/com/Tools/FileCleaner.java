package com.Tools;

import java.io.File;
import java.io.FilenameFilter;

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
        String pathname = "C:\\aaa\\bbb";
        logger.info("{}", removeDuplicateFile(pathname));
    }

    static int removeDuplicateFile(String pathname) {
        Preconditions.checkArgument(pathname != null);
        Preconditions.checkArgument(StringUtils.isNotBlank(pathname));

        File file = new File(pathname);
        if (file.exists() && file.isDirectory()) {
            File[] dirs = file.listFiles();
            for (File dir : dirs) {
                if (dir.isDirectory() && !dir.getName().endsWith("galler")) {
                    File[] files = dir.listFiles(new FilenameFilter() {
                        public boolean accept(File dir, String name) {
                            if (name.toLowerCase().contains(dir.getName().toLowerCase())) {//name.equalsIgnoreCase(dir.getName())
                                return false;
                            } else {
                                return true;
                            }
                        }
                    });
                    for (int i = 0; i < files.length; i++) {
                        System.out.println(files[i]);
                    }
                    logger.info("files.length = {}", files.length);

//                    for (int i = 0; i < files.length; i++) {
//                        files[i].delete();
//                    }
//                    logger.info("after deletion. files.length = {}", files.length);
                }
            }
        }

        return 0;
    }
}
