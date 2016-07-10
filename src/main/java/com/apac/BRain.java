package com.apac;

import java.io.PrintWriter;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.apac.Util.getPrintWriter;
import static com.apac.Util.printArray;

/**
 * Created by yanli_000 on 16/7/10.
 */
public class BRain {
    private final static Logger logger = LoggerFactory.getLogger(BRain.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new BRain().go();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private void go() {
        Scanner scanner = new Scanner(System.in);
        int numOfCasesT;
        if (scanner.hasNext()) {
            numOfCasesT = scanner.nextInt();
            PrintWriter printWriter = getPrintWriter("C:\\Users\\yanli_000\\Desktop\\ACountryLeader.out");

            for (int caseI = 0; caseI < numOfCasesT; caseI++) {
                int R = scanner.nextInt();
                int C = scanner.nextInt();
                scanner.nextLine();
                logger.info("M = {}, C = {}", R, C);
                int[][] H = new int[R][C];
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        H[i][j] = scanner.nextInt();
                    }
                }
                printArray(H, R, C);

//                String result = "Case #" + (caseI + 1) + ": " + leaderEntries.get(0);
//                System.out.println(result);
//                printWriter.println(result);
            }

            printWriter.flush();
        }
    }
}
