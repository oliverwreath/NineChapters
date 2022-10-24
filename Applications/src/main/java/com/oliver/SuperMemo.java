package com.oliver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

/**
 * Author: Oliver
 * Spaced repetition Software:
 * Your little assistant that reminds you the right review at the right time.
 * reads your provided Customized Cards.json.
 */
@Slf4j
public class SuperMemo {
  private static final int GENERATING_DAYS = 30;
  private static final String CARDS_PATH = "src/main/resources/nocommit/Cards.json";//src/main/resources/CardsExample.json
  private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

  public static void main(String[] args) throws ParseException {
    String directory = getArgsDirectory();
    List<Card> cards = readCards(directory);
    Map<LocalDate, Queue<Card>> cardsBySortedDate = groupCardsByDate(cards);
    log.info(String.format("cardsBySortedDate.size()=%d", cardsBySortedDate.size()));
    log.info("========================================================");
    for (Map.Entry<LocalDate, Queue<Card>> entry : cardsBySortedDate.entrySet()) {
      LocalDate dueDate = entry.getKey();
      Queue<Card> cardsOneDay = entry.getValue();
      boolean isPassDue = LocalDate.now().isAfter(dueDate);
      System.out.println("\t>>> reviewing at " + dueDate + (isPassDue ? " PASS_DUE!" : ""));
      cardsOneDay.forEach(System.out::println);
      if (isPassDue)
        System.out.println("");
    }
    log.info("========================================================");
  }

  static String getArgsDirectory() throws ParseException {
    Args arg = getArgs();
    boolean isPrintJsonStringExample = arg.getBoolean('l');
    boolean isPrintInstructions = arg.getBoolean('i');
    String directory = arg.getString('d');

    printRecommendedSpacedRepetitions();
    if (isPrintJsonStringExample) printJsonStringExample();
    if (isPrintInstructions) printInstructions();
    return directory;
  }

  private static void printInstructions() {
    System.out.println("1. Try to keep up with overdue. It will prevent forgetting.");
    System.out.println("2. if (performance == worse) Find it efficient to practice recoding the same thing right away.");
    System.out.println("3. For building blocks like countingSort, you should write as fast as you type.");
  }

  private static Args getArgs() throws ParseException {
    String schema = "i,l,p#,d*";
    String[] arguments = new String[]{"-i true", "-l false", "-p 123", "-d " + CARDS_PATH};
    return new Args(schema, arguments);
  }

  public static Map<LocalDate, List<Card>> sortMap(Map<LocalDate, List<Card>> dateCardMap) {
    dateCardMap.forEach((date, cards) -> Collections.sort(cards));
    return dateCardMap;
  }

  public static Map<LocalDate, Queue<Card>> groupCardsByDate(List<Card> cards) {
    Map<LocalDate, Queue<Card>> dateCardMap = new TreeMap<>();
    cards.forEach(card -> {
      Queue<Card> dateCards = dateCardMap.computeIfAbsent(card.getNextReviewedDate(), v -> new PriorityQueue<>());
      dateCards.add(card);
    });
    return dateCardMap;
  }

  private static void printJsonStringExample() {
    List<Card> listOfDtos = Lists.newArrayList(
            new Card("a", List.of("Arrays&Hashing", "EASY"), List.of(LocalDate.now(), LocalDate.now().minusDays(7))),
            new Card("bc", List.of("Arrays&Hashing", "HARD"), List.of(LocalDate.now(), LocalDate.now().minusDays(7)))
    );
    try {
      String jsonArray = mapper.writeValueAsString(listOfDtos);
      log.debug(jsonArray);
    } catch (JsonProcessingException e) {
      log.error(e.getMessage());
    }
  }

  private static boolean isValid(File json) {
    try {
      mapper.readTree(json);
    } catch (IOException e) {
      log.error(e.getMessage());
      return false;
    }
    return true;
  }

  static List<Card> readCards(String directory) {
    File file = Path.of(directory).toFile();
    if (!isValid(file))
      return Collections.emptyList();
    TypeReference<List<Card>> cardsType = new TypeReference<>() {
    };
    try {
      return mapper.readValue(file, cardsType);
    } catch (IOException e) {
      log.error(e.getMessage());
    }
    return Collections.emptyList();
  }

  private static void printRecommendedSpacedRepetitions() {
    Card.printRecommendedSpacedRepetitions();
  }
}
