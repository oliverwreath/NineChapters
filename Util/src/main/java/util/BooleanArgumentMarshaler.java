package util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.util.StringJoiner;

/**
 * Author: Oliver
 */
@Slf4j
public class BooleanArgumentMarshaler implements ArgumentMarshaler {
  private boolean booleanValue;

  @Override
  public void set(String currentArgument) throws ParseException {
    booleanValue = Boolean.parseBoolean(currentArgument);
  }

  public static boolean getValue(ArgumentMarshaler am) {
    if (am instanceof BooleanArgumentMarshaler)
      return ((BooleanArgumentMarshaler) am).booleanValue;
    else
      return false;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", BooleanArgumentMarshaler.class.getSimpleName() + "[", "]")
            .add("booleanValue=" + booleanValue)
            .toString();
  }
}
