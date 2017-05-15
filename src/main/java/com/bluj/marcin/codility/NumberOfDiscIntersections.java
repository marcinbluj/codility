package com.bluj.marcin.codility;

import java.util.Arrays;

/**
 * Created by MSI on 14.05.2017.
 */
public class NumberOfDiscIntersections {
    public int solution(int[] A) { //TODO just 75%
        // write your code in Java SE 8
        int length = A.length;
        int intersections = 0;
        int currentDiscIndex = 0;

        Integer[] leftValues = new Integer[A.length];

        for (int i = 0; i < A.length; i++) {
            leftValues[i] = i - A[i];
        }

        while (currentDiscIndex < length - 1) {
            long rightRange = (long) currentDiscIndex + A[currentDiscIndex];
            for (int i = currentDiscIndex + 1; i < length; i++) {
                int leftRange = leftValues[i];
                if (rightRange >= leftRange) {
                    intersections++;
                }
            }
            currentDiscIndex++;
            if (intersections >= 10000000) {
                return -1;
            }
        }
        return intersections;
    }

    public int solution2(int[] A) { //100% :)
        // write your code in Java SE 8
        int intersection = 0;
        int length = A.length;
        int[] leftValues = new int[length];
        
        for (int i = 0; i < length; i++) {
            leftValues[i] = i - A[i];
        }
        Arrays.sort(leftValues);

        for (int i = 0; i < length - 1; i++) {
            long rightValue = (long) A[i] + i;
            for (int j = i + 1; j < length; j++) {
                if (rightValue >= leftValues[j]) {
                    intersection++;
                } else {
                    break;
                }
            }
            if (intersection > 10000000) {
                return -1;
            }
        }
        return intersection;
    }
}
