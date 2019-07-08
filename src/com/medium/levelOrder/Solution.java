package com.medium.levelOrder;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        three.left = nine;
        three.right = twenty;

        twenty.left = fifteen;
        twenty.right = seven;

        levelOrder(three);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> st = new LinkedList<>();
        st.add(root);
        while (!st.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = st.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = st.poll();
                list.add(node.val);
                if (node.left != null) {
                    st.offer(node.left);
                }
                if (node.right != null) {
                    st.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
//        if (root == null) return new ArrayList<>();
//        List<List<Integer>> result = new ArrayList<>();
//        dfs(result, root, 0);
//        return result;
    }

    private static void dfs(List<List<Integer>> result, TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if(result.size() < level+1){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        dfs(result, node.left,level+1);
        dfs(result, node.right, level+1);
    }


}
