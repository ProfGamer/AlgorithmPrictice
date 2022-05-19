package com.datastructure.algorithmprictice.myPrictice.RealQuestion.HuaWei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Xin Yuchen
 * @Date: 2022/5/17 - 05 - 17 - 1:31
 * @Description: Any Ques or Concerns, plz contact e0838400@u.nus.edu
 */
public class SodaBottle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();
        while (s.hasNextLine()) { // 按行获取输入
            int number = s.nextInt();
            if (number == 0) { // 如果输入0, 则结束输入
                break;
            } else {
                input.add(number);
            }
        }
        s.close();
        for (Integer i : input) {
            int res = canDrinkHowManySoda(i);
            System.out.println(res);
        }


    }

    public static int canDrinkHowManySoda(int blankBottle) {

        if (blankBottle == 1) { // 空瓶子为1 时 不能向老板借瓶子
            return 0;
        }
        if (blankBottle == 2) { // 可以向老板借一个 换一瓶, 喝掉之后三个空瓶子换一瓶, 还给老板
            return 1;
        }
        int chargeBottle = blankBottle / 3; // 这一轮换了多少瓶 -> 喝完变成空瓶子
        int restBlankBottle = chargeBottle + blankBottle % 3; // 剩多少空瓶子没换
        return chargeBottle + canDrinkHowManySoda(restBlankBottle);
    }
}
