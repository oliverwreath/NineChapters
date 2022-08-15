package com.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.IntFunction;

/**
 * Author: Oliver
 */
@Slf4j
@Data
public class Card {
  private String name;
  private List<String> tags;
  private List<LocalDate> reviewedAt;
  private static final IntFunction<Integer> func = x -> x * x;

  public Card() {
  }

  public Card(String name, List<String> tags, List<LocalDate> reviewedAt) {
    this.name = name;
    this.tags = tags;
    this.reviewedAt = reviewedAt;
  }

  public int getReviewedTimes() {
    return reviewedAt.size();
  }

  public LocalDate getLastReviewedDate() {
    return Collections.max(reviewedAt);
  }

  public int daysTillNext() {
    return func.apply(getReviewedTimes());
  }

  public LocalDate getNextReviewedDate() {
    return getLastReviewedDate().plusDays(daysTillNext());
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Card.class.getSimpleName() + "[", "]")
      .add("name='" + name + "'")
      .add("tags=" + tags)
      .add("reviewedAt=" + reviewedAt)
      .toString();
  }
}
