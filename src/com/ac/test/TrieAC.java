package com.ac.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author zhai
 * @date 2022/4/27 8:29 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class TrieAC {

    private StateNode startNode;
    private int stateCount;
    private List<StateNode> correspondingNode;
    private List<StateNode> fail;

    public TrieAC() {
        this.startNode = new StateNode();
        this.stateCount = 0;
        this.correspondingNode = new ArrayList<>();
        correspondingNode.add(startNode);
        this.fail = new ArrayList<>();
    }

    void loadPattern(List<String> patterns) {
        int latestState = 1;
        int count = 0;
        for (String pattern : patterns) {
            StateNode node = startNode;
            for (int i = 0; i < pattern.length(); ++i) {
//                StateNode nextNode = node.getTransitionTable().get(0x22 - patterns.get(i));
            }
        }
    }

    void dispose() {

    }

    void match(String str, Set<Integer> matched) {

    }
}
