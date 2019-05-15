package com.jsj.leetcode.backtracking;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: []
 * <p>
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 * <p>
 * 思路：...待研究
 *
 * @author jsj
 * @date 2019-05-15
 */
public class Solution126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //结果
        List<List<String>> res = new ArrayList<>();
        if (wordList == null) return res;
        //bfs搜索所用的字典
        Set<String> dicts = new HashSet<>(wordList);
        if (!dicts.contains(endWord)) return res;
        if (dicts.contains(beginWord)) dicts.remove(beginWord);
        //bfs搜索最短路径所用的开始和结束的字典
        Set<String> endList = new HashSet<>(), beginList = new HashSet<>();
        //每个点所对应的邻接点，list
        Map<String, List<String>> map = new HashMap<>();
        beginList.add(beginWord);
        endList.add(endWord);
        bfs(map, beginList, endList, beginWord, endWord, dicts, false);
        //dfs的前进路线保存list
        List<String> subList = new ArrayList<>();
        subList.add(beginWord);
        dfs(map, res, subList, beginWord, endWord);
        return res;
    }

    private void dfs(Map<String, List<String>> map,
             List<List<String>> result, List<String> subList,
             String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(subList));
            return;
        }
        if (!map.containsKey(beginWord)) {
            return;
        }
        for (String word : map.get(beginWord)) {
            subList.add(word);
            dfs(map, result, subList, word, endWord);
            subList.remove(subList.size() - 1);
        }
    }

    //reverse是双端bfs的一个优化
    private void bfs(Map<String, List<String>> map, Set<String> beginList, Set<String> endList, String beginWord, String endWord, Set<String> wordList, boolean reverse) {
        if (beginList.size() == 0) return;
        wordList.removeAll(beginList);
        boolean finish = false;
        Set<String> temp = new HashSet<>();
        for (String str : beginList) {
            char[] charr = str.toCharArray();
            for (int chI = 0; chI < charr.length; chI++) {
                char old = charr[chI];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == old)
                        continue;
                    charr[chI] = ch;
                    String newstr = new String(charr);
                    if (!wordList.contains(newstr)) {
                        continue;
                    }
                    //若是在某一层找到了最后的节点，就直接标记找到了，即一票决定。这里因为要找所有的最短路径，所以循环还是要继续的。
                    if (endList.contains(newstr)) {
                        finish = true;
                    } else {
                        temp.add(newstr);
                    }
                    //无论怎么变换方向，永远用开始方向的字符做key，是为了后面的dfs，单一方向搜索
                    String key = reverse ? newstr : str;
                    String value = reverse ? str : newstr;
                    if (!map.containsKey(key)) {
                        map.put(key, new ArrayList<>());
                    }
                    map.get(key).add(value);

                }
                charr[chI] = old;
            }
        }
        if (!finish) {
            if (temp.size() > endList.size()) {
                bfs(map, endList, temp, beginWord, endWord, wordList, !reverse);
            } else {
                bfs(map, temp, endList, beginWord, endWord, wordList, reverse);
            }
        }
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("hot");
        wordDict.add("dot");
        wordDict.add("dog");
        wordDict.add("log");
        wordDict.add("lot");
        wordDict.add("cog");
        List<List<String>> lists = new Solution126().findLadders("hit", "cog", wordDict);
        for (List<String> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
        System.out.println();
    }
}
