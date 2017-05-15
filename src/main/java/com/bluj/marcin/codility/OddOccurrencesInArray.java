package com.bluj.marcin.codility;

import java.util.Arrays;

/**
 * Created by MSI on 14.05.2017.
 */
public class OddOccurrencesInArray {
    public int solution(int[] A) { //100%
        // write your code in Java SE 8
        Arrays.sort(A);
        int length = A.length;
        for (int i = 1; i < length; i += 2) {
            int previousIndex = i - 1;
            if (A[i] != A[previousIndex]) {
                return A[previousIndex];
            }
        }
        return A[length-1];
    }
}
