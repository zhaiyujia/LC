package com.ac.test;

import java.util.List;

/**
 * @author zhai
 * @date 2022/4/27 8:27 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */

public class StateNode {

    private boolean finish;
    private int state;
    private int num;
    private String pattern;
    private List<StateNode>  transitionTable;

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public List<StateNode> getTransitionTable() {
        return transitionTable;
    }

    public void setTransitionTable(List<StateNode> transitionTable) {
        this.transitionTable = transitionTable;
    }
}
