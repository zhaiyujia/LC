你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。
8返回你可以印出的非空字母序列的数目。

 

示例 1：
输入："AAB"
输出：8
解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。


示例 2：
输入："AAABBC"
输出：188


提示：
1 <= tiles.length <= 7
tiles 由大写英文字母组成

回溯算法  深度优先遍历
https://www.cnblogs.com/steven_oyj/archive/2010/05/22/1741376.html