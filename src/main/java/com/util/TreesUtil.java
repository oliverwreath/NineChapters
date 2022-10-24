package com.util;

import java.util.LinkedList;
import java.util.Queue;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TreesUtil {

  static String printWholeTreeByLevel(TreeNode root) {
    if (root == null)
      return "";

    int depth = maxDepth(root);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    StringBuilder sb = new StringBuilder();
    for (int d = 0; d < depth; d++) {
      int factor = (int) Math.pow(2, depth - d - 1) - 1;
      String spaces = String.format("%4.4s", "").repeat(factor);
      int n = queue.size();
      for (int i = 0; i < n; i++) {
        TreeNode poll = queue.poll();
        if (d < depth - 1 && i > 0)
          sb.append(spaces);
        sb.append(String.format("%3.3s%s", (poll == null ? "#" : poll.val), (i == n - 1 ? "" : ",")));
        if (poll != null) {
          queue.add(poll.left);
          queue.add(poll.right);
        } else {
          queue.add(null);
          queue.add(null);
        }
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  static int maxDepth(TreeNode root) {
    if (root == null)
      return 0;

    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}
