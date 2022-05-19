package com.datastructure.algorithmprictice.myPrictice.StringRetreatment;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/13 - 05 - 13 - 22:47
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
// https://leetcode.cn/problems/reverse-words-in-a-string/
// 调换字符串中单词的顺序 并且去除字符串前后的多余空格 并保证单词间只有一个空格
public class ReverseWordAndRemoveSpace {
    public static void main(String[] args) {
        String s = "   This    is Good   ";
        System.out.println(forceReverseWords(s));


    }

    public static String reverseWords(String s) {
        // 先去掉所有空格
        StringBuilder stringBuilder = removeSpace(s);
        // 再将所有字符串翻转
        reverseString(stringBuilder, 0, stringBuilder.length() - 1);
        // 再将单词翻转
        reverseWords(stringBuilder);
        return stringBuilder.toString();
    }

    // 去除字符串前后及单词间多余的空格
    public static StringBuilder removeSpace(String str) {
        StringBuilder res = new StringBuilder();
        // 先让双指针移动到前后不是空格的位置
        int start = 0;
        int end = str.length() - 1;
        while (str.charAt(start) == ' ') {
            start++;
        }
        while (str.charAt(end) == ' ') {
            end--;
        }
        // 在start ~ end 范围上去除单词间多余的空格
        while (start <= end) {
            // 如果这个字符不是空格 -> 加进去
            // 如果这个字符是空格, 但是他上一个字符不是空格
            if (str.charAt(start) != ' ' || res.charAt(res.length() - 1) != ' ') {
                res.append(str.charAt(start));
            }
            start++;
        }
        return res;
    }

    // 将字符串翻转
    public static void reverseString(StringBuilder str, int start, int end) {
        while (start < end) {
            char temp = str.charAt(start);
            str.setCharAt(start++, str.charAt(end));
            str.setCharAt(end--, temp);
        }
    }

    // 将StringBuilder中的所有单词顺序反过来
    public static void reverseWords(StringBuilder str) {
        int start = 0;
        int end = 0;
        //遍历string
        while (end <= str.length() - 1) {
            if (str.charAt(end) == ' ') {
                reverseString(str, start, end - 1);
                start = end + 1;
            }
            if (end == str.length() - 1) {
                reverseString(str, start, end);
            }
            end++;
        }
    }

    public static String forceReverseWords(String str) {
        String[] s = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] != " " && s[i] != "") {
                sb.append(s[i] + " ");
            }
        }
        return sb.toString().trim();
    }
}
