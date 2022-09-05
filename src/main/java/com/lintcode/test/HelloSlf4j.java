package com.lintcode.test;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Yanliang Han on 2016/5/29.
 */
@Slf4j
public class HelloSlf4j {
  public static void main(String[] args) {
    log.trace("this is a trace msg!");
    log.debug("this is a debug msg!");
    log.info("this is a info msg!");
    log.warn("this is a warn msg!");
    log.error("this is an error msg!");
  }
}
