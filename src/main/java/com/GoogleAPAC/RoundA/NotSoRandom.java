package com.GoogleAPAC.RoundA;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.GoogleAPAC.RoundA.Util.getPrintWriter;

/**
 * Created by yanli_000 on 16/7/9.
 */
public class NotSoRandom {
    private final static Logger logger = LoggerFactory.getLogger(NotSoRandom.class);

    private final static BigInteger BIG_INTEGER_100 = BigInteger.valueOf(100);
    private final static BigDecimal BIG_DECIMAL_100 = BigDecimal.valueOf(100);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new NotSoRandom().notSoRandom();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private void notSoRandom() {
        Scanner scanner = new Scanner(System.in);
        int numOfCases;
        if (scanner.hasNext()) {
            numOfCases = scanner.nextInt();
            PrintWriter printWriter = getPrintWriter("C:\\Users\\yanli_000\\Desktop\\notSoRandom.out");

            for (int caseI = 0; caseI < numOfCases; caseI++) {
                BigInteger N = scanner.nextBigInteger();
                BigInteger X = scanner.nextBigInteger();
                BigInteger K = scanner.nextBigInteger();
                BigDecimal A = scanner.nextBigDecimal().divide(BIG_DECIMAL_100);
                BigDecimal B = scanner.nextBigDecimal().divide(BIG_DECIMAL_100);
                BigDecimal C = scanner.nextBigDecimal().divide(BIG_DECIMAL_100);
                Map<BigInteger, BigDecimal> chanceMap = new HashMap<BigInteger, BigDecimal>();
                chanceMap.put(X, BigDecimal.ONE);
                logger.info("N = {}, X = {}, K = {}, A = {}, B = {}, C = {}", N, X, K, A, B, C);
                System.out.println("A = " + A + "; B = " + B + "; C = " + C);
                BigDecimal numberFromString = getExpectation(chanceMap, N, K, A, B, C);
                String result = "Case #" + (caseI + 1) + ": " + numberFromString;
//                System.out.println(result);
                printWriter.println(result);
            }

            printWriter.flush();
        }
    }

    private BigDecimal getExpectation(Map<BigInteger, BigDecimal> chanceMap, BigInteger N, BigInteger K, final BigDecimal A, final BigDecimal B, final BigDecimal C) {
        logger.info("chanceMap = {}, N = {}, K = {}, A = {}, B = {}, C = {}", chanceMap, N, K, A, B, C);

        for (long i = 0; i < N.longValue(); i++) {
            getOneExpectation(chanceMap, K, A, B, C);
        }

        BigDecimal resultDecimal = BigDecimal.ZERO;
        for (BigInteger key : chanceMap.keySet()) {
            resultDecimal = resultDecimal.add(new BigDecimal(key).multiply(chanceMap.get(key)));
        }
        return resultDecimal;
    }

    private void getOneExpectation(Map<BigInteger, BigDecimal> chanceMap, BigInteger K, final BigDecimal A, final BigDecimal B, final BigDecimal C) {
        logger.trace("A = {}, B = {}, C = {}", A, B, C);
        logger.debug("chanceMap Before = {}", chanceMap);
        Map<BigInteger, BigDecimal> newChanceMap = new HashMap<BigInteger, BigDecimal>();

        for (BigInteger key : chanceMap.keySet()) {
            add2Map(newChanceMap, key.and(K), chanceMap.get(key).multiply(A));
            add2Map(newChanceMap, key.or(K), chanceMap.get(key).multiply(B));
            add2Map(newChanceMap, key.xor(K), chanceMap.get(key).multiply(C));
        }

        chanceMap.clear();
        for (BigInteger key : newChanceMap.keySet()) {
            chanceMap.put(key, newChanceMap.get(key));
        }

        logger.debug("chanceMap After = {}", chanceMap);
        return;
    }

    private void add2Map(Map<BigInteger, BigDecimal> chanceMap, BigInteger key, BigDecimal chance) {
        if (chanceMap.containsKey(key)) {
            chanceMap.put(key, chanceMap.get(key).add(chance));
        } else {
            chanceMap.put(key, chance);
        }
    }

    private ResultType getResultType(BigInteger expectation, BigInteger lastNegative) {
        return new ResultType(expectation.add(lastNegative.multiply(BIG_INTEGER_100)).divideAndRemainder(BIG_INTEGER_100));
    }

    private class ResultType {
        BigInteger positive;
        BigInteger negative;

        public ResultType(BigInteger[] divideAndRemainder) {
            this.positive = divideAndRemainder[0];
            this.negative = divideAndRemainder[1];
        }

        public ResultType(BigInteger positive, BigInteger negative) {
            this.positive = positive;
            this.negative = negative;
        }

        @Override
        public String toString() {
            return "ResultType{" +
                    "positive=" + positive +
                    ", negative=" + negative +
                    '}';
        }
    }

/**
 N, X, K, A, B, and C
 Input

 Output

 3
 1 5 5 10 50 40
 2 5 5 10 50 40
 10 15 21 70 20 10

 Case #1: 3.0000000000
 Case #2: 3.6000000000
 Case #3: 15.6850579098
 **/
}
