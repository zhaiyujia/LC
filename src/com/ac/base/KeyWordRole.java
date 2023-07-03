package com.ac.base;

/**
 * @author zhai
 * @date 2022/4/28 10:51 AM
 * @illustration
 * @slogan: Treat others the way you want to be treated
 * @version:
 */
public class KeyWordRole {

    /**
     * 规则ID
     */
    private int roleId;

    /**
     * 关键词规则树
     */
    private KeyWordTrie trie;


    public KeyWordRole(int roleId, KeyWordTrie trie) {
        this.roleId = roleId;
        this.trie = trie;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public KeyWordTrie getTrie() {
        return trie;
    }

    public void setTrie(KeyWordTrie trie) {
        this.trie = trie;
    }
}
