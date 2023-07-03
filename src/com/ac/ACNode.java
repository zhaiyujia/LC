package com.ac;

/**
 * @author zhai
 * @date 2022/4/27 8:18 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class ACNode {

    char c;
    boolean isEnding;
    int length = -1;

    ACNode[] children = new ACNode[26];
    ACNode fail;

    ACNode(char c) {
        this.c = c;
    }

}
