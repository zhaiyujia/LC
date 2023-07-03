package com.ac.base;

import com.ac.test1.PattenString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhai
 * @date 2022/4/28 10:52 AM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class TestKeyWordRole {

    public static void main(String[] args) {

        KeyWordTrie keyWordTrie = new KeyWordTrie(false);
        keyWordTrie.addElement("测试");
        keyWordTrie.addElement("您好");
        keyWordTrie.constructFailureStates();

        KeyWordRole role = new KeyWordRole(1, keyWordTrie);

        List<KeyWordRole> roles = new ArrayList<>();
        roles.add(role);


        /**
         * 1 精确匹配
         * 2 模糊匹配
         */
        int matchType = 1;
        String str = "测试，是谁发送的消息，单个关键词匹配";
        // 模糊匹配
        for (KeyWordRole keyWordRole : roles) {
            KeyWordTrie trie = keyWordRole.getTrie();
            List<PattenString> match = trie.fuzzyMatch(str);
            for (PattenString pattenWord : match) {
                System.out.println(pattenWord.getStart() + " " + pattenWord.getEnd() + "\t" + pattenWord.getKeyword());
            }
        }
//
//        // 精确匹配
//        for (KeyWordRole keyWordRole : roles) {
//            KeyWordTrie trie = keyWordRole.getTrie();
//            List<PattenString> match = trie.accurateMatch(str);
//            if(match != null && match.size() > 0){
//                // 匹配失败了
//                for (PattenString pattenWord : match) {
//                    System.out.println(pattenWord.getStart() + " " + pattenWord.getEnd() + "\t" + pattenWord.getKeyword());
//                }
//            }
//        }

    }

}
