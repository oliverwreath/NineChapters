package com.oliver;

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
  private int estimateMinutes;
  private DIFFICULTY difficulty;
  private PERFORMANCE lastPerformance = PERFORMANCE.GOOD;
  private List<String> tags;
  private List<LocalDate> reviewedAt;
  private static final IntFunction<Integer> func = x -> 5 * x * x + 2;

  enum DIFFICULTY {
    EASY, MEDIUM, HARD
  }

  public enum PERFORMANCE {
    READY, GOOD, BAD, WORST
  }

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
    return getLastReviewedDate().plusDays(getNextReviewedGapInDays());
  }

  public long getNextReviewedGapInDays() {
    return Math.max(daysTillNext() - ((lastPerformance.ordinal() - 1) * 3), 1);
  }

  @Override
  public int compareTo(Card c) {
    int compare = this.getNextReviewedDate().compareTo(c.getNextReviewedDate());
    if (compare != 0) return compare;
    compare = Integer.compare(this.estimateMinutes, c.estimateMinutes);
    if (compare != 0) return compare;
    return lastPerformance.compareTo(c.lastPerformance);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Card.class.getSimpleName() + "[", "]")
//      .add("name='" + (name.length()>=25?name.substring(0, 22)+"...":String.format("%-25s",name)) + "'")
            .add("name=" + String.format("%-30.30s", name))
            .add("estimate=" + String.format("%-3d", estimateMinutes))
            .add(String.format("%-6s", difficulty))
            .add(String.format("%-5s", lastPerformance))
            .add("nextReviewedGapInDays=" + getNextReviewedGapInDays())
//      .add("nextReviewedDate=" + getNextReviewedDate())
//      .add("lastReviewedDate=" + getLastReviewedDate())
            .add("tags=" + tags)
            .toString();
  }

  public static void printRecommendedSpacedRepetitions() {
    StringBuilder title = new StringBuilder();
    StringBuilder content = new StringBuilder();
    for (int i = 1; i < 10; i++) {
      title.append(String.format("#%-2.2s; ", i));
      content.append(String.format("%3.3s; ", func.apply(i)));
    }
    content.append(" (days)");
    log.info(title.toString());
    log.info(content.toString());
  }
}
