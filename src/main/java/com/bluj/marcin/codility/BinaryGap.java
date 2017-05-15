package com.bluj.marcin.codility;

/**
 * Created by MSI on 14.05.2017.
 */
public class BinaryGap {
    public int solution(int N) {
        // write your code in Java SE 8
        String binaryN = Integer.toBinaryString(N);
        int counter = 0;
        int maxGap = 0;
        boolean has1 = false;
        for (int i = 0; i < binaryN.length(); i++) {
            if (binaryN.charAt(i) == '1') {
                has1 = true;
                maxGap = (counter > maxGap) ? counter : maxGap;
                counter = 0;
            } else {
                if (has1) {
                    counter++;
                }
            }
        }
        return maxGap;
    }

    public int solution2(int N) {
        // write your code in Java SE 8
        String binaryN = Integer.toBinaryString(N);
        int maxGap = 0;
        int gap;
        int indexOf1 = -1;
        for (int i = 0; i < binaryN.length(); i++) {
           if (binaryN.charAt(i) == '1') {
               if (indexOf1 != -1) {
                   gap = (i - indexOf1) - 1;
                   if (gap > maxGap) {
                       maxGap = gap;
                   }
               }
               indexOf1 = i;
           }
        }
        return maxGap;
    }
}
