package com.bluj.marcin.codility;

import java.util.*;

/**
 * Created by MSI on 15.05.2017.
 */
public class Fish {
    private List<Integer> indexList = new ArrayList<>();

    public int solution(int[] A, int[] B) { //100% but ugly
        // write your code in Java SE 8
        fillIndexList(A);
        int counter = 0;
        int index = 0;
        do {
            Integer indexFromArray = indexList.get(index);
            if (index == 0 && B[indexFromArray] == 0) {
                indexList.remove(index);
                counter++;
            } else if (index == indexList.size() - 1 && B[indexFromArray] == 1) {
                indexList.remove(index);
                counter++;
                index--;
            } else if (B[indexFromArray] == 1) {
                index++;
            } else {
                fightAndRemoveLoser(A, index, index - 1);
                index--;
            }
        } while (indexList.size() > 0);
        return counter;
    }

    private void fillIndexList(int[] A) {
        for (int i = 0; i < A.length; i++) {
            indexList.add(i);
        }
    }

    private void fightAndRemoveLoser(int[] A, int i1, int i2) {
        int loser = (A[indexList.get(i1)] > A[indexList.get(i2)]) ? i2 : i1;
        indexList.remove(loser);
    }
}
