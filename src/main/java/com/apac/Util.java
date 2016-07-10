package com.apac;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import com.google.common.base.Throwables;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli_000 on 16/7/8.
 */
public class Util {
    private final static Logger logger = LoggerFactory.getLogger(Util.class);

    public static void main(String[] args) {
        new Util().testLeaderRanking3();
    }

    public static class LeaderEntry implements Comparable {
        String name;
        int distinctCount;

        public LeaderEntry(String name) {
            this.name = name;
            this.distinctCount = getDistinctAlphabetCount(name);
        }

        public LeaderEntry(String name, int distinctCount) {
            this.name = name;
            this.distinctCount = distinctCount;
        }

        @Override
        public String toString() {
            return name;
        }

//        @Override
//        public String toString() {
//            return "LeaderEntry{" +
//                    "name='" + name + '\'' +
//                    ", distinctCount=" + distinctCount +
//                    '}';
//        }

        public int compareTo(Object o) {
            if (o == null) {
                return 0;
            }
            if (o instanceof LeaderEntry) {
                LeaderEntry anotherLeaderEntry = (LeaderEntry) o;
                if (this.distinctCount == anotherLeaderEntry.distinctCount) {
                    return this.name.compareTo(anotherLeaderEntry.name);
                } else {
                    return anotherLeaderEntry.distinctCount - this.distinctCount;
                }
            } else {
                return 0;
            }
        }
    }

    public void testLeaderRanking() {
        ArrayList<LeaderEntry> leaderEntries = new ArrayList<LeaderEntry>();
        leaderEntries.add(new LeaderEntry("ADAM"));
        leaderEntries.add(new LeaderEntry("BOB"));
        leaderEntries.add(new LeaderEntry("JOHNSON"));
        logger.info("before sort = {}", leaderEntries);
        Collections.sort(leaderEntries);
        logger.info("after sort = {}", leaderEntries);
    }

    public void testLeaderRanking2() {
        ArrayList<LeaderEntry> leaderEntries = new ArrayList<LeaderEntry>();
        leaderEntries.add(new LeaderEntry("A AB C"));
        leaderEntries.add(new LeaderEntry("DEF"));
        logger.info("before sort = {}", leaderEntries);
        Collections.sort(leaderEntries);
        logger.info("after sort = {}", leaderEntries);
    }

    public void testLeaderRanking3() {
        ArrayList<LeaderEntry> leaderEntries = new ArrayList<LeaderEntry>();
        leaderEntries.add(new LeaderEntry("ADAM"));
        leaderEntries.add(new LeaderEntry("BOB"));
        leaderEntries.add(new LeaderEntry("JOHNSON"));
        leaderEntries.add(new LeaderEntry("A AB C"));
        leaderEntries.add(new LeaderEntry("DEF"));
        logger.info("before sort = {}", leaderEntries);
        Collections.sort(leaderEntries);
        logger.info("after sort = {}", leaderEntries);
    }

    public void testGetDistinctAlphabetCount() {
        System.out.println(new LeaderEntry("ADAM"));
        System.out.println(new LeaderEntry("BOB"));
        System.out.println(new LeaderEntry("JOHNSON"));
        System.out.println(new LeaderEntry("A AB C"));
        System.out.println(new LeaderEntry("DEF"));
    }

    public static int getDistinctAlphabetCount(String name) {
        if (StringUtils.isBlank(name)) {
            return 0;
        }

        int len = name.length();
        HashSet<Character> tmpSet = new HashSet<Character>();
        for (int i = 0; i < len; i++) {
            char oneChar = name.charAt(i);
            if (oneChar != ' ') {
                tmpSet.add(oneChar);
            }
        }

        return tmpSet.size();
    }

    public static PrintWriter getPrintWriter(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || file.isDirectory()) {
            try {
                file.createNewFile();
            } catch (Exception ex) {
                logger.error(Throwables.getStackTraceAsString(ex));
            }
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
        } catch (FileNotFoundException ex) {
            logger.error(Throwables.getStackTraceAsString(ex));
        }
        return writer;
    }
}
