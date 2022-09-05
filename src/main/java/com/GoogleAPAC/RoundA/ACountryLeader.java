package com.GoogleAPAC.RoundA;

import lombok.extern.slf4j.Slf4j;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static com.GoogleAPAC.RoundA.Util.getPrintWriter;

/**
 * Created by yanli_000 on 16/7/10.
 */
@Slf4j
public class ACountryLeader {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    new ACountryLeader().go();
    log.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
  }

  private void go() {
    Scanner scanner = new Scanner(System.in);
    int numOfCasesT;
    if (scanner.hasNext()) {
      numOfCasesT = scanner.nextInt();
      PrintWriter printWriter = getPrintWriter("C:\\Users\\yanli_000\\Desktop\\ACountryLeader.out");

      for (int caseI = 0; caseI < numOfCasesT; caseI++) {
        int numOfLeadersN = scanner.nextInt();
        scanner.nextLine();
        log.info("numOfLeadersN = {}", numOfLeadersN);
        ArrayList<Util.LeaderEntry> leaderEntries = new ArrayList<Util.LeaderEntry>();
        for (int i = 0; i < numOfLeadersN; i++) {
          leaderEntries.add(new Util.LeaderEntry(scanner.nextLine()));
        }
        log.info("before sort = {}", leaderEntries);
        Collections.sort(leaderEntries);
        log.info("after sort = {}", leaderEntries);
        String result = "Case #" + (caseI + 1) + ": " + leaderEntries.get(0);
//                log.debug(result);
        printWriter.println(result);
      }

      printWriter.flush();
    }
  }
}
