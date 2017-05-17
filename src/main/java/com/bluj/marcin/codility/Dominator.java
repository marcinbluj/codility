package com.bluj.marcin.codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MSI on 17.05.2017.
 */
public class Dominator {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int index = -1;

        int length = A.length;
        for (int i = 0; i < length; i++) {
            int key = A[i];
            if (map.containsKey(key)) {
                int current = map.get(key) + 1;
                map.replace(key, current);
                if (current > count) {
                    count = current;
                    index = i;
                }
            } else {
                map.put(A[i], 1);
                if (1 > count) {
                    count = 1;
                    index = i;
                }
            }
        }
        return ((double) count / length > 0.5d) ? index : -1;
    }
}
