package com.bluj.marcin.codility;

import java.util.Collections;

/**
 * Created by MSI on 14.05.2017.
 */
public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int length = A.length;
        if (length <= 1 || K % length == 0) {
            return A;
        }

        int rotation = K % length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int indexAfterRotation = (i + rotation) % length;
            result[indexAfterRotation] = A[i];
        }
        return result;
    }

    public int[] solution2(int[] A, int K) {
        // write your code in Java SE 8
        int length = A.length;
        if (length <= 1 || K % length == 0) {
            return A;
        }

        int rotation = K % length;
        int[] result = new int[length];

        System.arraycopy(A, length - rotation, result, 0, rotation);
        System.arraycopy(A, 0, result, rotation, length - rotation);
        return result;
    }
}
