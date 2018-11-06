package com.labyrinths.utilities;

import java.util.List;
import java.util.Map;

public class LabyrinthUtility {
  private LabyrinthUtility() {}

  public static < K > K findSmallestKey(Map<K, Integer> map, List<K> keys) {
    K minKey = null;
    int minValue = Integer.MAX_VALUE;

    for (K key : keys) {
      int value = map.get(key);
      if (value < minValue) {
        minValue = value;
        minKey = key;
      }
    }
    return minKey;
  }
}
