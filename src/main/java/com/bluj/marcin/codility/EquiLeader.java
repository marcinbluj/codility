package com.bluj.marcin.codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MSI on 16.05.2017.
 */
public class EquiLeader {
    public int solution(int[] A) { //100% correctness 88% overall and ugly code
        // write your code in Java SE 8
        int[] sortedA = Arrays.stream(A).sorted().toArray();

        int[] leader = new int[]{sortedA[0], 0};
        int[] current = new int[]{1_000_000_001, 0};

        int sortedLength = sortedA.length;
        for (int i = 0; i < sortedLength; i++) {
            if (sortedA[i] != current[0]) {
                if (current[1] > leader[1]) {
                    leader[0] = current[0];
                    leader[1] = current[1];
                }
                current[0] = sortedA[i];
                current[1] = 1;

            } else {
                current[1]++;
                if (i == sortedLength - 1 && current[1] > leader[1]) {
                    leader[0] = current[0];
                    leader[1] = current[1];
                }
            }
        }

        int length = A.length;
        if ((double) leader[1] / length <= 0.5) {
            return 0;
        } else if (leader[1] == length) {
            return length - 1;
        }

        int equiLeaderCount = 0;
        int counter = 0;
        double firstPart;
        double secondPart;
        for (int i = 0; i < length; i++) {
            if (A[i] == leader[0]) {
                counter++;
            }
            firstPart = (double) counter / (i + 1);
            secondPart = (double) (leader[1] - counter) / (length - (i + 1));
            if ((firstPart > 0.5d) && secondPart > 0.5) {
                equiLeaderCount++;
            }
        }
        return equiLeaderCount;
    }

    public int solution2(int[] A) { //100% still ugly code
        // write your code in Java SE 8
        Map<Integer, Integer> map = new HashMap<>();
        int leaderCount = 0;
        Integer leaderValue = null;

        for (int key : A) {
            if (map.containsKey(key)) {
                Integer count = map.get(key) + 1;
                map.replace(key, count);
                if (count > leaderCount) {
                    leaderCount = count;
                    leaderValue = key;
                }
            } else {
                map.put(key, 1);
            }
        }

        if (leaderValue == null) return 0;
        int length = A.length;
        if ((double) leaderCount / length <= 0.5d) return 0;
        if (leaderCount == length) return length - 1;

        int equiCount = 0;
        int counter = 0;

        for (int i = 0; i < length; i++) {
            if (A[i] == leaderValue) {
                counter++;
            }

            double firestPart = (double) counter / (i + 1);
            double secondPart = (double) (leaderCount - counter) / (length - (i + 1));
            if (firestPart > 0.5d && secondPart > 0.5d) {
                equiCount++;
            }
        }
        return equiCount;
    }
}
