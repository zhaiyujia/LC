package com.ac;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhai
 * @date 2022/4/27 8:18 PM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class StreamChecker {

    ACNode root;
    ACNode p;

    public StreamChecker(String[] words) {
        // 构造字典树
        this.root = new ACNode(' ');
        this.p = root;
        for (String word : words) {
            ACNode temp = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (temp.children[idx] == null) temp.children[idx] = new ACNode(c);
                temp = temp.children[idx];
            }
            temp.isEnding = true;
            temp.length = word.length();
        }
        // 维护失败指针
        buildFailPointer();
    }

    private void buildFailPointer() {
        Queue<ACNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ACNode p = queue.poll();
            for (int i = 0; i < 26; i++) {
                ACNode pc = p.children[i];
                if (pc == null) continue;

                if (p == root) pc.fail = root;
                else {
                    ACNode q = p.fail;
                    while (q != null && q.children[i] == null) {
                        q = q.fail;
                    }

                    if (q == null) pc.fail = root;
                    else pc.fail = q.children[i];
                }
                queue.add(pc);
            }
        }
    }

    public boolean query(char letter) {
        int idx = letter - 'a';
        while (this.p != root && p.children[idx] == null) {
            p = p.fail;
        }
        p = p.children[idx];
        if (p == null) p = root;

        ACNode temp = p;
        while (temp != root) {
            if (temp.isEnding) return true;
            temp = temp.fail;
        }

        return false;

    }
}
