package com.oliver;

import java.text.ParseException;
import java.util.StringJoiner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class StringArgumentMarshaler implements ArgumentMarshaler {

  private String stringValue;

  @Override
  public void set(String currentArgument) throws ParseException {
    stringValue = currentArgument;
  }

  public static String getValue(ArgumentMarshaler am) {
    if (am instanceof StringArgumentMarshaler)
      return ((StringArgumentMarshaler) am).stringValue;
    else
      return "";
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", StringArgumentMarshaler.class.getSimpleName() + "[", "]")
        .add("stringValue='" + stringValue + "'")
        .toString();
  }
}
