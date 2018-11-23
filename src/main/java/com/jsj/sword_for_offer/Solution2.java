package main.java.com.jsj.sword_for_offer;

/**
 * @author jsj
 * @since 2018-5-12
 * 题目描述：请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Solution2 {
    public String replaceSpace(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch == ' ') {
                result.append("%20");
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
