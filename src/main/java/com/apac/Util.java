package com.apac;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli_000 on 16/7/8.
 */
public class Util {
    private final static Logger logger = LoggerFactory.getLogger(Util.class);

    public static PrintWriter getPrintWriter(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || file.isDirectory()) {
            try {
                file.createNewFile();
            } catch (Exception ex) {
                logger.error(Throwables.getStackTraceAsString(ex));
            }
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException ex) {
            logger.error(Throwables.getStackTraceAsString(ex));
        }
        return writer;
    }
}
