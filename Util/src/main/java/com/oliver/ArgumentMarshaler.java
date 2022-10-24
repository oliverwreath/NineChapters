package com.oliver;

import java.text.ParseException;

/**
 * Author: Oliver
 */
public interface ArgumentMarshaler {
  void set(String currentArgument) throws ParseException;
}
