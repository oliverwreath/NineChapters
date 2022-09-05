package com.AmazonSession.leetcode.algorithms;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC223RectangleArea {
  /**
   * horizontal CG AE
   * vertical DH BF
   * @return
   */
  public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    long area1 = ((long) ax2 - ax1) * (ay2 - ay1);
    long area2 = ((long) bx2 - bx1) * (by2 - by1);
    long overlap = overLapRectangle(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);

    return (int) (area1 + area2 - overlap);
  }

  public long overLapRectangle(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    if (bx2 < ax1 || ax2 < bx1 || by2 < ay1 || ay2 < by1) {
      return 0;
    } else {
      return (Math.min((long) bx2, ax2) - Math.max(ax1, bx1)) * (Math.min(ay2, by2) - Math.max(ay1, by1));
    }
  }
}
