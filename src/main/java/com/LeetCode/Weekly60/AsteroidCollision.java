package com.LeetCode.Weekly60;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class AsteroidCollision {
    private static final Logger logger = LoggerFactory.getLogger(AsteroidCollision.class);

    public static void main(String[] args) {
        testAsteroidCollision();
    }

    private static void testAsteroidCollision() {
        AsteroidCollision AsteroidCollision = new AsteroidCollision();
        MyLogger.info("result [5, 10] v.s. " + Arrays.toString(AsteroidCollision.asteroidCollision(new int[]{5, 10, -5})));
        MyLogger.info("result [-2, -2, -2, 1] v.s. " + Arrays.toString(AsteroidCollision.asteroidCollision(new int[]{-2, -2, -2, 1})));
    }

    /**
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length < 1) {
            return asteroids;
        }

        // core logic
        int len = asteroids.length;
        int i = 0;
        int count = asteroids.length;
        for (int j = 1; j < len; j++) {
            if (i < 0) {
                asteroids[++i] = asteroids[j];
            } else {
                if (asteroids[i] > 0 && asteroids[j] < 0) {
                    if (-asteroids[i] == asteroids[j]) {
                        count -= 2;
                        i--;
                    } else {
                        count--;
                        if (Math.abs(asteroids[i]) < Math.abs(asteroids[j])) {
                            i--;
                            j--;
                        }
                    }
                } else {
                    asteroids[++i] = asteroids[j];
                }
            }
        }
//        System.out.println(i);
        int[] result = new int[count];
        for (int i1 = 0; i1 < result.length; i1++) {
            result[i1] = asteroids[i1];
        }
        return result;
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
