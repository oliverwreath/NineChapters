package com.oliver;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class Args {

  private Map<Character, ArgumentMarshaler> marshalers;
  private Set<Character> argsFound;
  private ListIterator<String> currentArgument;

  public boolean getBoolean(char arg) {
    return BooleanArgumentMarshaler.getValue(marshalers.get(arg));
  }

  public String getString(char arg) {
    return StringArgumentMarshaler.getValue(marshalers.get(arg));
  }

  public int getInt(char arg) {
    return IntegerArgumentMarshaler.getValue(marshalers.get(arg));
  }

  enum ErrorCode {
    OK, MISSING_STRING
  }

  private ErrorCode errorCode = ErrorCode.OK;

  public Args(String schema, String[] args) throws ParseException {
    if (schema.length() == 0 && args.length == 0)
      return;
    marshalers = new HashMap<>();
    argsFound = new HashSet<>();

    parseSchema(schema);
    parseArgumentStrings(Arrays.asList(args));
  }

  private void parseArgumentStrings(List<String> args) throws ParseException {
    for (String arg : args) {
      if (arg.startsWith("-")) {
        char argChar = arg.charAt(1);
        String argString = arg.substring(3);
        marshalers.get(argChar).set(argString);
      } else {
        currentArgument.previous();
        break;
      }
    }
  }

  private void parseSchema(String schema) throws ParseException {
    for (String element : schema.split(",")) {
      if (element.length() > 0)
        parseSchemaElement(element.trim());
    }
  }

  private void parseSchemaElement(String element) throws ParseException {
    char elementId = element.charAt(0);
    String elementTail = element.substring(1);
    validateSchemaElementId(elementId);
    if (elementTail.isEmpty())
      marshalers.put(elementId, new BooleanArgumentMarshaler());
    else if (elementTail.equals("#"))
      marshalers.put(elementId, new IntegerArgumentMarshaler());
    else if (elementTail.equals("*"))
      marshalers.put(elementId, new StringArgumentMarshaler());
    else
      throw new ParseException("Invalid argument format:" + elementId, 0);
  }

  private void validateSchemaElementId(char elementId) throws ParseException {
    if (!Character.isLetter(elementId)) {
      throw new ParseException("Invalid argument name:" + elementId, 0);
    }
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Args.class.getSimpleName() + "[", "]")
        .add("marshalers=" + marshalers)
        .add("argsFound=" + argsFound)
        .add("currentArgument=" + currentArgument)
        .add("errorCode=" + errorCode)
        .toString();
  }
}
