package com.apacRoundA;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.apacRoundA.Util.getPrintWriter;

/**
 * Created by yanli_000 on 16/7/6.
 */

// Extend HttpServlet class
public class LazySpellingBee {
    private final static Logger logger = LoggerFactory.getLogger(LazySpellingBee.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new LazySpellingBee().lazySpellingBee();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public void lazySpellingBee() {
        Scanner scanner = new Scanner(System.in);
        int numOfCases;
        if (scanner.hasNext()) {
            numOfCases = scanner.nextInt();
            PrintWriter printWriter = getPrintWriter("C:\\Users\\yanli_000\\Desktop\\spellingBee.out");

            for (int caseI = 0; caseI < numOfCases; caseI++) {
                String target = scanner.next();
                BigInteger numberFromString = getNumberFromString(target);
                String result = "Case #" + (caseI + 1) + ": " + numberFromString;
//                System.out.println(result);
                printWriter.println(result);
            }

            printWriter.flush();
        }
    }

    private static BigInteger getNumberFromString(String target) {
        if (StringUtils.isBlank(target)) {
            return BigInteger.ONE;
        } else if (target.length() < 2) {
            return BigInteger.ONE;
        }

        int len = target.length();
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i < len - 1; i++) {
            Set<Character> tmpSet = new HashSet<Character>();
            tmpSet.add(target.charAt(i - 1));
            tmpSet.add(target.charAt(i));
            tmpSet.add(target.charAt(i + 1));
            result = result.multiply(BigInteger.valueOf(tmpSet.size()));
        }

        result = result.multiply(BigInteger.valueOf(target.charAt(0) == target.charAt(1) ? 1 : 2));
        result = result.multiply(BigInteger.valueOf(target.charAt(len - 2) == target.charAt(len - 1) ? 1 : 2));

        return result.mod(BigInteger.valueOf(1000000007));
    }
}