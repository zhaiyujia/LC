package com.ac.test1;


import java.util.*;

public class ACTrie {

    private Boolean failureStatesConstructed = false;   //是否建立了failure表
    private Node root;                                  //根结点


    public ACTrie() {
        this.root = new Node(true);
    }


    /**
     * 添加一个模式串(内部使用字典树构建)
     */
    public void addKeyword(String keyword) {
        if (keyword == null || keyword.length() == 0) {
            return;
        }
        Node currentState = this.root;
        for (Character character : keyword.toCharArray()) {
            //如果char已经在子节点里，返回这个节点的node；否则建一个node，并将map(char,node)加到子节点里去
            currentState = currentState.insert(character);
        }
        //在每一个尾节点处，将从root到尾节点的整个string添加到这个叶节点的PattenString里
        currentState.addPattenString(keyword);
    }


    /**
     * 用ac自动机做匹配，返回text里包含的pattern及其在text里的起始位置
     */
    public Collection<PattenString> parseText(String text, int matchType) {

        Node currentState = this.root;
        List<PattenString> collectedPattenStrings = new ArrayList<>();
        for (int position = 0; position < text.length(); position++) {
            Character character = text.charAt(position);
            //依次从子节点里找char，如果子节点没找到，就到子节点的fail node找，并返回最后找到的node；如果找不到就会返回root
            //这一步同时也在更新currentState，如果找到了就更新currentState为找到的node，没找到currentState就更新为root，相当于又从头开始找
            currentState = currentState.nextState(character);
            Collection<String> PattenStrings = currentState.PattenString();
            if (PattenStrings == null || PattenStrings.isEmpty()) {
                if (matchType == 2) {
                    collectedPattenStrings.add(new PattenString(0, 0, null));
                    return collectedPattenStrings;
                }
                continue;
            }
            //如果找到的node的PattenString非空，说明有pattern被匹配到了
            for (String PattenString : PattenStrings) {
                collectedPattenStrings.add(new PattenString(position - PattenString.length() + 1, position, PattenString));
            }
        }
        return collectedPattenStrings;//返回匹配到的所有pattern
    }


    /**
     * 建立Fail表(核心,BFS遍历)
     */
    private void constructFailureStates() {
        Queue<Node> queue = new LinkedList<>();

        //首先从把root的子节点的fail node全设为root
        //然后将root的所有子节点加到queue里面
        for (Node depthOneState : this.root.children()) {
            depthOneState.setFailure(this.root);
            queue.add(depthOneState);
        }
        this.failureStatesConstructed = true;

        while (!queue.isEmpty()) {
            Node parentNode = queue.poll();
            //下面给parentNode的所有子节点找fail node
            for (Character transition : parentNode.getTransitions()) {           //transition是父节点的子节点的char
                Node childNode = parentNode.find(transition);                    //childNode是子节点中对应上面char值的节点的Node值
                queue.add(childNode);                                            //将这个parentNode的所有子节点加入queue，在parentNode的所有兄弟节点都过了一遍之后，就会过这些再下一层的节点
                Node failNode = parentNode.getFailure().nextState(transition);   //利用父节点的fail node来构建子节点的fail node
                childNode.setFailure(failNode);

                //每个节点处的PattenString要加上它的fail node处的PattenString
                //因为能匹配到这个位置的话，那么fail node处的PattenString一定是匹配的pattern
                childNode.addPattenString(failNode.PattenString());
            }
        }
    }


    /**
     * 检查是否建立了Fail表(若没建立，则建立)
     */
    public void checkForConstructedFailureStates() {
        if (!this.failureStatesConstructed) {
            constructFailureStates();
        }
    }


}


