package com.GoogleAPAC.RoundA;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.GoogleAPAC.RoundA.Util.getPrintWriter;

/**
 * Created by yanli_000 on 16/7/10.
 */
public class ACountryLeader {
    private static final Logger logger = LoggerFactory.getLogger(ACountryLeader.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new ACountryLeader().go();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
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
                logger.info("numOfLeadersN = {}", numOfLeadersN);
                ArrayList<Util.LeaderEntry> leaderEntries = new ArrayList<Util.LeaderEntry>();
                for (int i = 0; i < numOfLeadersN; i++) {
                    leaderEntries.add(new Util.LeaderEntry(scanner.nextLine()));
                }
                logger.info("before sort = {}", leaderEntries);
                Collections.sort(leaderEntries);
                logger.info("after sort = {}", leaderEntries);
                String result = "Case #" + (caseI + 1) + ": " + leaderEntries.get(0);
//                System.out.println(result);
                printWriter.println(result);
            }

            printWriter.flush();
        }
    }
}
