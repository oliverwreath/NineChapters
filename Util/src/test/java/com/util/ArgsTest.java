package com.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.oliver.Args;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Author: Oliver
 */
@Slf4j
class ArgsTest {

  @SneakyThrows
  @Test void test_JUnit() {
    String schema = "l,p#,d*";
    String[] args = new String[]{"-l false", "-p 123", "-d dText"};
    Args arg = new Args(schema, args);
    boolean isLogging = arg.getBoolean('l');
    int port = arg.getInt('p');
    String directory = arg.getString('d');
    assertFalse(isLogging);
    assertEquals(123, port);
    assertEquals("dText", directory);
    log.info(String.valueOf(arg));
  }
}
