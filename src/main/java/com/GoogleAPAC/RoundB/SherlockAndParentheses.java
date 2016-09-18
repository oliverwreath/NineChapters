package com.GoogleAPAC.RoundB;

import java.io.PrintWriter;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.GoogleAPAC.RoundA.Util.getPrintWriter;

/**
 * Created by yanli on 8/28/2016.
 */
public class SherlockAndParentheses {
    private final static Logger logger = LoggerFactory.getLogger(SherlockAndParentheses.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        testGetResult();
        SherlockAndParentheses();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static void SherlockAndParentheses() {
        Scanner scanner = new Scanner(System.in);
        int numOfCases;
        if (scanner.hasNext()) {
            numOfCases = scanner.nextInt();
            PrintWriter printWriter = getPrintWriter("C:\\Users\\yanli\\IdeaProjects\\JiuZhang\\src\\main\\resources\\SherlockAndParentheses.out.txt");

            for (int caseI = 1; caseI <= numOfCases; caseI++) {
                int left = scanner.nextInt();
                int right = scanner.nextInt();
                int min = Math.min(left, right);
                String result = "Case #" + caseI + ": " + getResult(min);
//                System.out.println(result);
                printWriter.println(result);
            }

            printWriter.flush();
        }
    }

    public static void testGetResult() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + getResult(i));
        }
    }

    public static int getResult(int n) {
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            ret += i;
        }
        return ret;
    }
}
