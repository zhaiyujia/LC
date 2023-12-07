package com.leetcode.interview.a.canCompleteCircuit;

/**
 * @author zhai
 * @date 2023/12/6 2:14 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class Solution {

    public static void main(String[] args) {
        t1();
        t2();
        t3();
        t4();
        t5();
    }


    private static void t1() {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};

//        int[] gas = new int[]{2};
//        int[] cost = new int[]{2};

        int i = canCompleteCircuit2(gas, cost);
        System.out.println("t1:" + i);
    }

    private static void t2() {
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        // -1 -1 1

        int i = canCompleteCircuit2(gas, cost);
        System.out.println("t2:" + i);
    }

    private static void t3() {
        int[] gas = new int[]{3, 3, 4};
        int[] cost = new int[]{3, 4, 4};
        // 0 -1  0

        int i = canCompleteCircuit2(gas, cost);
        System.out.println("t3:" + i);
    }

    private static void t4() {
        int[] gas = new int[]{5, 1, 2, 3, 4};
        int[] cost = new int[]{4, 4, 1, 5, 1};
        // 1 -3 1 -2 3

        int i = canCompleteCircuit2(gas, cost);
        System.out.println("t4:" + i);
    }

    private static void t5() {
        int[] gas = new int[]{3, 1, 1};
        int[] cost = new int[]{1, 2, 2};
        // 2 -1 -1

        int i = canCompleteCircuit2(gas, cost);
        System.out.println("t5:" + i);
    }

    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int[] c = new int[gas.length];
        int sumC = 0;
        for (int i = 0; i < gas.length; i++) {
            c[i] = gas[i] - cost[i];
            sumC += c[i];
        }

        if (sumC < 0) {
            return -1;
        }

        int start = 0;
        int allMoney = 0;
        for (int i = 0; i < c.length; i++) {
            allMoney += c[i];
            if (allMoney < 0) {
                allMoney = 0;
                start = i + 1;
            }
        }

        return start;
    }


    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int[] c = new int[gas.length];

        int sumG = 0;
        int sumC = 0;
        for (int i = 0; i < gas.length; i++) {
            c[i] = gas[i] - cost[i];
            sumG += gas[i];
            sumC += cost[i];
        }
        if (sumG < sumC) {
            return -1;
        }

        outerLoop:
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 0) {
                int sum = 0;
                for (int j = i; j < c.length; j++) {
                    if (c[j] + sum < 0) {
                        continue outerLoop;
                    } else {
                        sum = sum + c[j];
                    }
                }

                for (int k = 0; k < i; k++) {
                    sum = sum + c[k];
                    if (sum < 0) {
                        continue outerLoop;
                    }
                }
                if (sum >= 0) {
                    return i;
                }
            }
        }

        return -1;

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        /**
         * 条件分析
         *   1、加油站油量必须大于消耗的油量
         *   2、
         */

        int n = gas.length;
        int[] g1 = new int[n];
        g1[0] = gas[0];

        int[] c1 = new int[n];
        c1[0] = cost[0];
        for (int i = 1; i < gas.length; i++) {
            g1[i] = g1[i - 1] + gas[i];
            c1[i] = c1[i - 1] + cost[i];
        }

        int begin = 0;
        while (begin < n) {
            int index = 0;
            int yl = 0;
            for (int i = 0; i < n; i++) {
                if (yl + gas[i] > cost[i]) {
                    if (yl == 0) {
                        index = i;
                    }
                    // 走一步需要消耗的油量
                    // 从哪个位置走，可以算哪个位置之前的油量和 还有消耗的和 ，如果走到最后一步，进行计算 >0 则可以绕一圈
                    yl = yl + gas[i] - cost[i];
                }
            }
            if (index != 0) {
                if (yl + g1[index - 1] >= c1[index - 1]) {
                    return index;
                }
            }


            begin++;
        }


        return -1;
    }

}
