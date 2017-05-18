package com.bluj.marcin.codility;

/**
 * Created by MSI on 18.05.2017.
 */
public class MaxSliceSum {
    public int solution(int[] A) { //100%
        // write your code in Java SE 8

        int firstValue = A[0];
        int maxSum = firstValue;

        for (int i = 1, currentSum = firstValue; i < A.length; i++) {
            int currentValue = A[i];
            currentSum = (currentSum + currentValue > currentValue) ? currentSum + currentValue : currentValue;

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
