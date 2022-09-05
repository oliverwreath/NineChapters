package com.GoogleAPAC.RoundA;

import lombok.extern.slf4j.Slf4j;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

import static com.GoogleAPAC.RoundA.Util.getPrintWriter;

/**
 * Created by yanli_000 on 16/7/8.
 */
@Slf4j
public class RobotRockBand {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    new RobotRockBand().robotRockBand();
    log.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
  }

  public void robotRockBand() {
    Scanner scanner = new Scanner(System.in);
    int numOfCases;
    if (scanner.hasNext()) {
      numOfCases = scanner.nextInt();
      PrintWriter printWriter = getPrintWriter("C:\\Users\\yanli_000\\Desktop\\RobotRockBand.out");

      for (int caseI = 0; caseI < numOfCases; caseI++) {
        int N = scanner.nextInt();
        long K = scanner.nextLong();
        myCountedSet<Long> set1 = new myCountedSet<Long>();
        myCountedSet<Long> set2 = new myCountedSet<Long>();
        myCountedSet<Long> set3 = new myCountedSet<Long>();
        myCountedSet<Long> set4 = new myCountedSet<Long>();
        for (int j = 0; j < N; j++) {
          set1.add(scanner.nextLong());
        }
        for (int j = 0; j < N; j++) {
          set2.add(scanner.nextLong());
        }
        for (int j = 0; j < N; j++) {
          set3.add(scanner.nextLong());
        }
        for (int j = 0; j < N; j++) {
          set4.add(scanner.nextLong());
        }
        BigInteger xorHitCount = getXORHitCount(set1, set2, set3, set4, K);
        String result = "Case #" + (caseI + 1) + ": " + xorHitCount;
//                log.debug(result);
        printWriter.println(result);
      }

      printWriter.flush();
    }
  }

  private class myCountedSet<E> implements Iterable<E> {
    Set<E> set = new HashSet<E>();
    Map<E, BigInteger> map = new HashMap<E, BigInteger>();

    public myCountedSet() {
    }

    public void add(E key) {
      if (set.contains(key)) {
        map.put(key, map.get(key).add(BigInteger.ONE));
      } else {
        set.add(key);
        map.put(key, BigInteger.ONE);
      }
    }

    public void add(E key, BigInteger count) {
      if (set.contains(key)) {
        map.put(key, map.get(key).add(count));
      } else {
        set.add(key);
        map.put(key, count);
      }
    }

    public BigInteger getCounter(long key) {
      return map.get(key);
    }

    public int size() {
      return set.size();
    }

    public Set<E> getSet() {
      return set;
    }

    public Map<E, BigInteger> getMap() {
      return map;
    }

    public Iterator<E> iterator() {
      return set.iterator();
    }

    @Override
    public String toString() {
      return "myCountedSet{" +
              "map=" + map +
              '}';
    }
  }

  private BigInteger getXORHitCount(myCountedSet<Long> set1, myCountedSet<Long> set2, myCountedSet<Long> set3, myCountedSet<Long> set4, long target) {
    log.debug("{}", set1);
    log.debug("{}", set2);
    log.debug("{}", set3);
    log.debug("{}", set4);
    log.info("{} {} {} {}", set1.size(), set2.size(), set3.size(), set4.size());
    long loopSize = (long) set1.size() * set2.size() * set3.size() * set4.size();
    if (loopSize > 16930262059200L) {
      log.error("loopSize = {} too big!!", loopSize);
      return BigInteger.valueOf(-1);
    }

    BigInteger hitCount = BigInteger.ZERO;
    myCountedSet<Long> mySet1 = new myCountedSet<Long>();
    myCountedSet<Long> mySet2 = new myCountedSet<Long>();
    for (Long aLong1 : set1) {
      for (Long aLong2 : set2) {
        mySet1.add(aLong1 ^ aLong2 ^ target, set1.getCounter(aLong1).multiply(set2.getCounter(aLong2)));
      }
    }
    for (Long aLong3 : set3) {
      for (Long aLong4 : set4) {
        mySet2.add(aLong3 ^ aLong4, set3.getCounter(aLong3).multiply(set4.getCounter(aLong4)));
      }
    }
    log.info("{} {}", mySet1.size(), mySet2.size());
    int loopSize2 = mySet1.size();
    for (Long aLong1 : mySet1) {
      if (mySet2.getSet().contains(aLong1)) {
        hitCount = hitCount.add(mySet1.getCounter(aLong1).multiply(mySet2.getCounter(aLong1)));
        log.debug("HIT!! {}", aLong1);
      } else {
        log.debug("MISS!! {}", aLong1);
      }
    }

    log.info("hloopSize = {}; loopSize2 = {}; hitCount is {}", loopSize, loopSize2, hitCount);
    return hitCount;
  }
}
