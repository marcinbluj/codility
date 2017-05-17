package com.bluj.marcin.codility;

/**
 * Created by MSI on 17.05.2017.
 */
public class MaxProfit {
    public int solution(int[] A) {
        // write your code in Java SE 8

        int buyPrice = 200_001;
        int maxProfit = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] < buyPrice) {
                buyPrice = A[i];
            }
            int profit = A[i] - buyPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
