package com.ac.test1;

/**
 * @author zhai
 * @date 2022/4/27 11:02 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class PattenString {
    private String keyword;   //匹配到的模式串
    private int start;        //起点
    private int end;          //终点

    public PattenString(int start, int end, String keyword) {
        this.start = start;
        this.end = end;
        this.keyword = keyword;
    }



    public String getKeyword() {
        return this.keyword;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return super.toString() + "=" + this.keyword;
    }
}
