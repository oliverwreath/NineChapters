package com.ATemplatesDataStructures.BinarySearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No74_FirstBadVersion {
  public static void main(String[] args) {
    testNo141_SqrtX();
  }

  private static void testNo141_SqrtX() {
    No74_FirstBadVersion No141_SqrtX = new No74_FirstBadVersion();
//        log.info("result 0 v.s. " + No141_SqrtX.sqrt(0));
//        log.info("result 1 v.s. " + No141_SqrtX.sqrt(1));
//        log.info("result 1 v.s. " + No141_SqrtX.sqrt(2));
//        log.info("result 1 v.s. " + No141_SqrtX.sqrt(3));
//        log.info("result 2 v.s. " + No141_SqrtX.sqrt(4));
//        log.info("result 2 v.s. " + No141_SqrtX.sqrt(5));
//        log.info("result 3 v.s. " + No141_SqrtX.sqrt(10));
  }

//    public int findFirstBadVersion(int n) {
//        // filter abnormal cases
//        if (n < 0) {
//            return 0;
//        }
//
//        int start = 0;
//        int end = n;
//        while (start + 1 < end) {
//            int mid = ((end - start) >> 1) + start;
//            if (SVNRepo.isBadVersion(mid)) {
//                end = mid;
//            } else {
//                start = mid;
//            }
//        }
//
//        if (SVNRepo.isBadVersion(start)) {
//            return start;
//        } else {
//            return end;
//        }
//    }

}
