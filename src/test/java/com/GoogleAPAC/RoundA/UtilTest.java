package com.GoogleAPAC.RoundA;

import static com.GoogleAPAC.RoundA.Util.oneDTrappingWater;

import com.GoogleAPAC.RoundA.Util.LeaderEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Author: Oliver
 */
@Slf4j
class UtilTest {

  @SneakyThrows
  @Test void test1DTrappingWater() {
    int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    log.info("a = {}", Arrays.toString(heights));

    int[] b = oneDTrappingWater(heights);
    log.info("b = {}", Arrays.toString(b));
//        int diff = 0;
//        for (int i = 0; i < heights.length; i++) {
//            diff += (b[i] - heights[i]);
//        }
//        log.info("diff = {}", diff);
  }

  @Test void testLeaderRanking() {
    ArrayList<LeaderEntry> leaderEntries = new ArrayList<>();
    leaderEntries.add(new LeaderEntry("ADAM"));
    leaderEntries.add(new LeaderEntry("BOB"));
    leaderEntries.add(new LeaderEntry("JOHNSON"));
    log.info("before sort = {}", leaderEntries);
    Collections.sort(leaderEntries);
    log.info("after sort = {}", leaderEntries);
  }

  @Test void testLeaderRanking2() {
    ArrayList<LeaderEntry> leaderEntries = new ArrayList<LeaderEntry>();
    leaderEntries.add(new LeaderEntry("A AB C"));
    leaderEntries.add(new LeaderEntry("DEF"));
    log.info("before sort = {}", leaderEntries);
    Collections.sort(leaderEntries);
    log.info("after sort = {}", leaderEntries);
  }

  @Test void testLeaderRanking3() {
    ArrayList<LeaderEntry> leaderEntries = new ArrayList<LeaderEntry>();
    leaderEntries.add(new LeaderEntry("ADAM"));
    leaderEntries.add(new LeaderEntry("BOB"));
    leaderEntries.add(new LeaderEntry("JOHNSON"));
    leaderEntries.add(new LeaderEntry("A AB C"));
    leaderEntries.add(new LeaderEntry("DEF"));
    log.info("before sort = {}", leaderEntries);
    Collections.sort(leaderEntries);
    log.info("after sort = {}", leaderEntries);
  }

  @Test void testGetDistinctAlphabetCount() {
    log.info(String.valueOf(new LeaderEntry("ADAM")));
    log.info(String.valueOf(new LeaderEntry("BOB")));
    log.info(String.valueOf(new LeaderEntry("JOHNSON")));
    log.info(String.valueOf(new LeaderEntry("A AB C")));
    log.info(String.valueOf(new LeaderEntry("DEF")));
  }
}
