package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/5/29.
 */
public class HelloSlf4j {
    private static final Logger logger = LoggerFactory.getLogger(HelloSlf4j.class);

    public static void main(String[] args) {
        logger.trace("this is a trace msg!");
        logger.debug("this is a debug msg!");
        logger.info("this is a info msg!");
        logger.warn("this is a warn msg!");
        logger.error("this is an error msg!");
    }
}
