package com.datastructure.algorithmprictice.myPrictice.StringRetreatment;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/6 - 05 - 06 - 14:56
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
public class Trim {
    public static void main(String[] args) {
        String test = "123 aa  a a aaa     a a " +"123";
        System.out.println(test.replaceAll(" ",""));
        String test2 = "        ";
        System.out.println(test2.replaceAll(" ","").equals(""));
    }
}
