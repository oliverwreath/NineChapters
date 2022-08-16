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
public class Card implements Comparable<Card> {
  private String name;
  private List<String> tags;
  private List<LocalDate> reviewedAt;
  private int estimateMinutes;
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
  public int compareTo(Card c) {
    int i = this.getNextReviewedDate().compareTo(c.getNextReviewedDate());
    if (i != 0) return i;
    return Integer.compare(this.estimateMinutes, c.estimateMinutes);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Card.class.getSimpleName() + "[", "]")
      .add("name='" + name + "'")
      .add("estimateMinutes=" + estimateMinutes)
      .add("getNextReviewedDate=" + getNextReviewedDate())
      .add("getLastReviewedDate=" + getLastReviewedDate())
      .add("tags=" + tags)
      .toString();
  }
}
