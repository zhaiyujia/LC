package com.lc.easy.defangIPaddr;

/**
 * Created by zhaiyj
 * date 2019/11/6 9:05 上午
 */
public class Solution {

    public static void main(String[] args) {
        String ip = "1.0.0.1";
        String s = defangIPaddr(ip);
        System.out.println(s);
    }

    public static String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }

}
