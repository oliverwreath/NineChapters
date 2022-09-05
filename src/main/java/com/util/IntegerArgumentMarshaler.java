package com.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.StringJoiner;

/**
 * Author: Oliver
 */
@Slf4j
public class IntegerArgumentMarshaler implements ArgumentMarshaler {
  private int intValue;

  @Override
  public void set(String currentArgument) throws ParseException {
    intValue = Integer.parseInt(currentArgument);
  }

  public static int getValue(ArgumentMarshaler am) {
    if (am instanceof IntegerArgumentMarshaler)
      return ((IntegerArgumentMarshaler) am).intValue;
    else
      return 0;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", IntegerArgumentMarshaler.class.getSimpleName() + "[", "]")
            .add("intValue=" + intValue)
            .toString();
  }
}
