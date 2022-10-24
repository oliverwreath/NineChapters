package com.oliver;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.List;

import static com.oliver.SuperMemo.getArgsDirectory;
import static com.oliver.SuperMemo.readCards;

/**
 * Author: Oliver
 */
@Slf4j
class SuperMemoTest {
  @Test void testReadCards() throws ParseException {
    String directory = getArgsDirectory();
    Assertions.assertEquals("src/main/resources/nocommit/Cards.json", directory);
    List<Card> cards = readCards(directory);
    Assertions.assertEquals(22, cards.size());
  }
}
