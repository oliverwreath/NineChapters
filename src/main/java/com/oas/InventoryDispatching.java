package com.oas;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Author: Oliver
 */
@Slf4j
public class InventoryDispatching {
  public static void main(String[] arg) {
    InventoryDispatching inventoryDispatching = new InventoryDispatching();
    List<int[]> result = inventoryDispatching.dispatching(new int[]{2, 4}, new int[]{3, 4}, new int[]{5, 4}, 2);
    System.out.print("result=");
    for (int[] ints : result) {
      System.out.print(Arrays.toString(ints) + " ");
    }
    System.out.println("");
    System.out.println("");

    result = inventoryDispatching.dispatching(new int[]{2, 4}, new int[]{3, 6}, new int[]{5, 9}, 1);
    System.out.print("result=");
    for (int[] ints : result) {
      System.out.print(Arrays.toString(ints) + " ");
    }
    System.out.println("");
    System.out.println("");

    result = inventoryDispatching.dispatching(new int[]{2, 4}, new int[]{3, 6}, new int[]{5, 9}, 2);
    System.out.print("result=");
    for (int[] ints : result) {
      System.out.print(Arrays.toString(ints) + " ");
    }
    System.out.println("");
    System.out.println("");

    result = inventoryDispatching.dispatching(new int[]{2, 4}, new int[]{3, 6}, new int[]{5, 9}, 3);
    System.out.print("result=");
    for (int[] ints : result) {
      System.out.print(Arrays.toString(ints) + " ");
    }
    System.out.println("");
    System.out.println("");

    result = inventoryDispatching.dispatching(new int[]{2, 4}, new int[]{3, 6}, new int[]{5, 9}, 4);
    System.out.print("result=");
    for (int[] ints : result) {
      System.out.print(Arrays.toString(ints) + " ");
    }
    System.out.println("");
    System.out.println("");

    result = inventoryDispatching.dispatching(new int[]{2, 4}, new int[]{3, 6}, new int[]{5, 9}, 5);
    System.out.print("result=");
    for (int[] ints : result) {
      System.out.print(Arrays.toString(ints) + " ");
    }
    System.out.println("");
    System.out.println("");

//    result = inventoryDispatching.dispatching(new int[]{2, 4}, new int[]{3, 4}, new int[]{5, 4}, 1);
//    System.out.print("result=");
//    for (int[] ints : result) {
//      System.out.print(Arrays.toString(ints) + " ");
//    }
//    System.out.println("");
//    System.out.println("");
//
//    result = inventoryDispatching.dispatching(new int[]{2, 4}, new int[]{3, 4}, new int[]{5, 4}, 3);
//    System.out.print("result=");
//    for (int[] ints : result) {
//      System.out.print(Arrays.toString(ints) + " ");
//    }
//    System.out.println("");
//    System.out.println("");
  }

  public List<int[]> dispatching(int[] currentInventories, int[] minimumInventories, int[] desiredInventories, int warehouseInventory) {
    // assuming the input has sorted by store names in alphabetical order.
    int numOfStores = currentInventories.length;
    List<int[]> result = new LinkedList<>();
    if (warehouseInventory == 0) {
      System.out.println("No shipments");
      return result;
    }

    // 1st step - assese the situation - T O(n), with n being numOfStores;
    int diffToMeetMinimum = 0, diffToFullyStock = 0;
    for (int i = 0; i < numOfStores; i++) {
      diffToMeetMinimum += (minimumInventories[i] > currentInventories[i]) ? (minimumInventories[i] - currentInventories[i]) : 0;
      diffToFullyStock += (desiredInventories[i] > currentInventories[i]) ? (desiredInventories[i] - currentInventories[i]) : 0;
    }

    // 2nd step - let's stock accordingly.
    if (warehouseInventory < diffToMeetMinimum) {
      // 1st Scenario - stock to the cloest fairness of the minimum.
      System.out.println("1st Scenario - stock to the cloest fairness of the minimum.");
      PriorityQueue<Store> pq = new PriorityQueue<>(new ComparatorLeastFair4Minimum());
      for (int i = 0; i < numOfStores; i++) {
        if (currentInventories[i] < minimumInventories[i]) {
          pq.offer(new Store(i, currentInventories[i], minimumInventories[i], desiredInventories[i]));
        }
      }
      System.out.println("pq=" + pq);
      // then use a pq to keep adding the least fair store.
      int availableItems = warehouseInventory;
      Map<Integer, Integer> mapID2Result = new HashMap<>();
      System.out.println("mapID2Result=" + mapID2Result);
      while (availableItems > 0) {
        int storeId = pq.peek().storeId;
        mapID2Result.put(storeId, mapID2Result.getOrDefault(storeId, 0) + 1);
        Store tmpStore = pq.poll();
        tmpStore.currentInventory++;
        pq.offer(tmpStore);
        System.out.println("pq=" + pq);
        availableItems--;
      }

      // finally convert the format.
      for (Map.Entry<Integer, Integer> entry : mapID2Result.entrySet()) {
        result.add(new int[]{entry.getKey() + 1, entry.getValue()});
      }
    } else if (warehouseInventory < diffToFullyStock) {
      // 2nd Scenario - stock pass the minimum; then to the cloest fairness of the desired.
      System.out.println("2nd Scenario - stock pass the minimum; then to the cloest fairness of the desired.");
      Map<Integer, Integer> mapID2Result = new HashMap<>();
      System.out.println("mapID2Result=" + mapID2Result);
      // first top up to minimum
      int availableItems = warehouseInventory;
      for (int i = 0; i < numOfStores; i++) {
        if (minimumInventories[i] > currentInventories[i]) {
          availableItems -= minimumInventories[i] - currentInventories[i];
          mapID2Result.put(i, minimumInventories[i] - currentInventories[i]);
          currentInventories[i] = minimumInventories[i];
        }
      }
      // then use a pq to keep adding the least fair store.
      PriorityQueue<Store> pq = new PriorityQueue<>(new ComparatorLeastFair4Desired());
      for (int i = 0; i < numOfStores; i++) {
        pq.offer(new Store(i, currentInventories[i], minimumInventories[i], desiredInventories[i]));
      }
      System.out.println("pq=" + pq);
      while (availableItems > 0) {
        int storeId = pq.peek().storeId;
        mapID2Result.put(storeId, mapID2Result.getOrDefault(storeId, 0) + 1);
        Store tmpStore = pq.poll();
        tmpStore.currentInventory++;
        pq.offer(tmpStore);
        System.out.println("pq=" + pq);
        availableItems--;
      }

      // finally convert the format.
      for (Map.Entry<Integer, Integer> entry : mapID2Result.entrySet()) {
        result.add(new int[]{entry.getKey() + 1, entry.getValue()});
      }
    } else {
      // 3rd Scenario - just stock to the fullest desired.
      System.out.println("3rd Scenario - just stock to the fullest desired.");
      for (int i = 0; i < numOfStores; i++) {
        if (desiredInventories[i] > currentInventories[i]) {
          result.add(new int[]{i + 1, desiredInventories[i] - currentInventories[i]});
        }
      }
    }

    return result;
  }

  private class ComparatorLeastFair4Minimum implements Comparator<Store> {
    @Override
    public int compare(Store o1, Store o2) {
      if (o1.currentInventory < o1.minimumInventory && o2.currentInventory >= o2.minimumInventory) {
        return -1;
      }
      if (o1.currentInventory >= o1.minimumInventory && o2.currentInventory < o2.minimumInventory) {
        return 1;
      }

      double ratio1 = (double)o1.currentInventory / (double)o1.minimumInventory;
      double ratio2 = (double)o2.currentInventory / (double)o2.minimumInventory;
      if (ratio1 == ratio2) {
        return o1.storeId - o2.storeId;
      }

      return Double.compare(ratio1, ratio2);
    }
  }

  private class ComparatorLeastFair4Desired implements Comparator<Store> {
    @Override
    public int compare(Store o1, Store o2) {
      if (o1.currentInventory < o1.desiredInventory && o2.currentInventory >= o2.desiredInventory) {
        return -1;
      }
      if (o1.currentInventory >= o1.desiredInventory && o2.currentInventory < o2.desiredInventory) {
        return 1;
      }

      double ratio1 = (double)o1.currentInventory / (double)o1.desiredInventory;
      double ratio2 = (double)o2.currentInventory / (double)o2.desiredInventory;
      if (ratio1 == ratio2) {
        return o1.storeId - o2.storeId;
      }

      return Double.compare(ratio1, ratio2);
    }
  }

  private class Store {
    int storeId;
    int currentInventory;
    int minimumInventory;
    int desiredInventory;

    public Store() {
      this.storeId = 0;
      this.currentInventory = 0;
      this.minimumInventory = 0;
      this.desiredInventory = 0;
    }
    public Store(int storeId, int currentInventory, int minimumInventory, int desiredInventory) {
      this.storeId = storeId;
      this.currentInventory = currentInventory;
      this.minimumInventory = minimumInventory;
      this.desiredInventory = desiredInventory;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("{");
      sb.append("id=").append(storeId);
      sb.append("; cur=").append(currentInventory);
      sb.append("; min=").append(minimumInventory);
      sb.append("; goal=").append(desiredInventory);
      sb.append("}");
      return sb.toString();
    }
  }
}


