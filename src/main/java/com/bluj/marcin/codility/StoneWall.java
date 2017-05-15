package com.bluj.marcin.codility;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by MSI on 15.05.2017.
 */
public class StoneWall {
    public int solution(int[] H) { //100% correctness, but overall just 50%
        // write your code in Java SE 8
        int counter = 0;
        Set<Integer> set = new HashSet<>();

        Set<Integer> higherValues;
        for (int i = 0; i < H.length; i++) {
            int currentHeight = H[i];
            higherValues = set.stream().filter(h -> h > currentHeight).collect(Collectors.toSet());
            counter += higherValues.size();
            set.removeAll(higherValues);

            set.add(H[i]);
        }
        counter += set.size();
        return counter;
    }

    public int solution2(int[] H) { //100% :)
        // write your code in Java SE 8
        int counter = 0;
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < H.length; i++) {
            while (!set.isEmpty() && H[i] < set.last()) {
                set.pollLast();
                counter++;
            }
            set.add(H[i]);
        }
        counter += set.size();
        return counter;
    }
}