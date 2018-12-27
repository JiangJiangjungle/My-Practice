package com.jsj.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jsj
 * @since 2018-12-26
 * 题目描述：给定一个文档 (Unix-style) 的完全路径，请进行路径简化。
 * <p>
 * 例如，
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * <p>
 * 边界情况:
 * <p>
 * 你是否考虑了 路径 = "/../" 的情况？
 * 在这种情况下，你需返回 "/" 。
 * 此外，路径中也可能包含多个斜杠 '/' ，如 "/home//foo/" 。
 * 在这种情况下，你可忽略多余的斜杠，返回 "/home/foo" 。
 */
public class Solution71 {
    public String simplifyPath(String path) {
        // 利用栈或队列来解决
        Deque<String> queue = new ArrayDeque<>();
        String[] paths = path.split("/");
        for (String p : paths) {
            if ("..".equals(p)) {
                if (!queue.isEmpty()) {
                    queue.removeLast();
                }
            } else if (!("".equals(p) || ".".equals(p))) {
                queue.addLast("/" + p);
            }
        }
        if (queue.isEmpty()) {
            return "/";
        } else {
            StringBuilder res = new StringBuilder();
            while (!queue.isEmpty()) {
                res.append(queue.removeFirst());
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution71().simplifyPath("/a/./b///../c/../././../d/..//../e"));
    }
}
