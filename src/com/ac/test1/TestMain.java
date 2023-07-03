package com.ac.test1;

import java.util.Collection;

/**
 * @author zhai
 * @date 2022/4/27 11:04 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class TestMain {

    public static void main(String[] args) {
        ACTrie trie = new ACTrie();
        trie.addKeyword("各位同学");
        trie.addKeyword("各位同学最近疫情很严重还是谁没提交核酸报告的抓紧提交");
        trie.checkForConstructedFailureStates();

        // 针对每个规则 生成一个AcTrie

        // 维护一个List<AcTrie>

        // 匹配 模糊匹配

        // 匹配 精确匹配 前缀相同, 之后出现failNode， 直接判断失败


        /**
         * 1 模糊匹配
         * 2 精确匹配
         */
        int type = 1;


        //匹配text，并返回匹配到的pattern
        Collection<PattenString> PattenStrings = trie.parseText("各位同学最近疫情很严重还是谁没提交核酸报告的抓紧提交", type);
        for (PattenString PattenString : PattenStrings) {
            System.out.println(PattenString.getStart() + " " + PattenString.getEnd() + "\t" + PattenString.getKeyword());
        }
    }

}
