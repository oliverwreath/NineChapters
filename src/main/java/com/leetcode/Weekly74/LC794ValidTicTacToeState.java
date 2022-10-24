package com.leetcode.Weekly74;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC794ValidTicTacToeState {

  public static void main(String[] args) {
    LC794ValidTicTacToeState LC794ValidTicTacToeState = new LC794ValidTicTacToeState();
    LC794ValidTicTacToeState.testNo794_ValidTicTacToeState();
  }

  private void testNo794_ValidTicTacToeState() {
    log.info("result false v.s. " + validTicTacToe(new String[]{"O  ", "   ", "   "}));
    log.info("result false v.s. " + validTicTacToe(new String[]{"XOX", " X ", "   "}));
    log.info("result false v.s. " + validTicTacToe(new String[]{"XXX", "   ", "OOO"}));
    log.info("result true v.s. " + validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
    log.info("result false v.s. " + validTicTacToe(new String[]{"XXX", "XOO", "OO "}));
  }

  boolean validTicTacToe(String[] A) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return false;
    }

    int XCount = 0;
    int OCount = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (A[i].charAt(j) == 'X') {
          XCount++;
        } else if (A[i].charAt(j) == 'O') {
          OCount++;
        }
      }
    }
    int XWinCount = 0;
    int OWinCount = 0;
    if (A[1].charAt(1) != ' ') {
      if (A[1].charAt(1) == 'X') {
        // * / \
        if (A[2].charAt(0) == 'X' && A[0].charAt(2) == 'X') {
          XWinCount++;
        }
        if (A[2].charAt(2) == 'X' && A[0].charAt(0) == 'X') {
          XWinCount++;
        }
        // + - |
        if (A[1].charAt(0) == 'X' && A[1].charAt(2) == 'X') {
          XWinCount++;
        }
        if (A[2].charAt(1) == 'X' && A[0].charAt(1) == 'X') {
          XWinCount++;
        }
      } else {
        // * / \
        if (A[2].charAt(0) == 'O' && A[0].charAt(2) == 'O') {
          OWinCount++;
        }
        if (A[2].charAt(2) == 'O' && A[0].charAt(0) == 'O') {
          OWinCount++;
        }
        // + - |
        if (A[1].charAt(0) == 'O' && A[1].charAt(2) == 'O') {
          OWinCount++;
        }
        if (A[2].charAt(1) == 'O' && A[0].charAt(1) == 'O') {
          OWinCount++;
        }
      }
    }
    if (A[0].charAt(0) != ' ') {
      if (A[0].charAt(0) == 'X') {
        // | -
        if (A[2].charAt(0) == 'X' && A[1].charAt(0) == 'X') {
          XWinCount++;
        }
        if (A[0].charAt(1) == 'X' && A[0].charAt(2) == 'X') {
          XWinCount++;
        }
      } else {
        // | -
        if (A[2].charAt(0) == 'O' && A[1].charAt(0) == 'O') {
          OWinCount++;
        }
        if (A[0].charAt(1) == 'O' && A[0].charAt(2) == 'O') {
          OWinCount++;
        }
      }
    }
    if (A[2].charAt(2) != ' ') {
      if (A[2].charAt(2) == 'X') {
        // | -
        if (A[0].charAt(2) == 'X' && A[1].charAt(2) == 'X') {
          XWinCount++;
        }
        if (A[2].charAt(0) == 'X' && A[2].charAt(1) == 'X') {
          XWinCount++;
        }
      } else {
        // | -
        if (A[0].charAt(2) == 'O' && A[1].charAt(2) == 'O') {
          OWinCount++;
        }
        if (A[2].charAt(0) == 'O' && A[2].charAt(1) == 'O') {
          OWinCount++;
        }
      }
    }
//        log.debug(XCount);
//        log.debug(OCount);
    if (XCount != OCount && XCount != (OCount + 1)) {
      return false;
    }
    if (XWinCount + OWinCount > 1) {
      return false;
    }
    if (XWinCount == 1) {
      return XCount == OCount + 1;
    } else if (OWinCount == 1) {
      return XCount == OCount;
    }
    return true;
  }

}
