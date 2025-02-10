package com.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {

    public static void main(String[] args) {

        int totalSize = 5;
        int removePercent = 20;
        int min = Math.min(
                new BigDecimal(totalSize)
                        .multiply(new BigDecimal(removePercent))
                        .divide(new BigDecimal(100), 0, RoundingMode.HALF_DOWN)
                        .intValue(),
                30
        );
        System.out.println(min);

    }

}
