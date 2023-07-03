package com.dp.kingGlod;

/**
 * @author zhaiyj
 * @date 2019/8/1 9:09
 * @description
 * 黄金矿工
 */
public class Glod {

    public static void main(String[] args) {
        int[] g = {400, 500, 200, 300, 350};
        int[] p = {5, 5, 3, 4, 3};
        getMostGold(5, 10, g, p);
    }

    /**
     * @param n 金矿数量n
     * @param w 工人数w
     * @param q 金矿的黄金量
     * @param p 金矿的用工量
     * @return
     */
    private static int getMostGold(int n, int w, int[] g, int[] p) {

        int col = w + 1;
        int[] preResults = new int[col];
        int[] results = new int[col];
        // 填充格子的边界值
        for (int i = 0; i < col; i++) {
            if (i < p[0]) {
                preResults[i] = 0;
            } else {
                preResults[i] = g[0];
            }
        }

        if (n == 1) {
            return preResults[w];
        }

        // 填充其余格子
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < col; j++) {
                if (j < p[i]) {
                    results[j] = preResults[j];
                } else {
                    results[j] = Math.max(preResults[j], preResults[j-p[i]] + g[i]);
                }
            }
            for (int j=0;j<col;j++){
                preResults[j] = results[j];
            }
        }
        return results[n];
    }

}
