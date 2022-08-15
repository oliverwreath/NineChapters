package com.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;

/**
 * Author: Oliver
 * Spaced repetition Software: reads your provided Customized Cards.csv.
 */
@Slf4j
public class SuperMemo {
  private static final int GENERATING_DAYS = 30;
  private static final String CARDS_PATH = "src/main/resources/Cards.json";
  private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

  public static void main(String[] args) {
    printRecommendedSpacedRepetitions();
//    printJsonStringExample();
    List<Card> cards = readCards();
    System.out.println(cards);
  }

  private static void printJsonStringExample() {
    List<Card> listOfDtos = Lists.newArrayList(
      new Card("a", List.of("Arrays&Hashing", "EASY"), List.of(LocalDate.now(), LocalDate.now().minusDays(7))),
      new Card("bc", List.of("Arrays&Hashing", "HARD"), List.of(LocalDate.now(), LocalDate.now().minusDays(7)))
    );
    try {
      String jsonArray = mapper.writeValueAsString(listOfDtos);
      System.out.println(jsonArray);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  private static boolean isValid(File json) {
    try {
      mapper.readTree(json);
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  private static List<Card> readCards() {
    File file = Path.of(CARDS_PATH).toFile();
    isValid(file);
    TypeReference<List<Card>> cardsType = new TypeReference<>() {
    };
    try {
      return mapper.readValue(file, cardsType);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return Collections.emptyList();
  }

  private static void printRecommendedSpacedRepetitions() {
    IntFunction<Integer> func = x -> x * x;
    for (int i = 1; i < 10; i++) {
      System.out.println(String.format("Day%d: %d", i, func.apply(i)));
    }
  }
}
