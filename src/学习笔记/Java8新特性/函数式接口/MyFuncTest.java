package 学习笔记.Java8新特性.函数式接口;


import org.junit.jupiter.api.Test;

import java.util.Locale;

/**
 * @Author: SongShengLin
 * @Date: 2022/07/21 10:17
 * @Describe:
 */
public class MyFuncTest {

    /**
     * 实现一个函数式接口
     */
    public static String handleString(MyFunc<String> myFunc, String str) {
        return myFunc.getValue(str);
    }


    @Test
    public void handleStringTest() {
        String abcToUpCase = handleString(s -> s.toUpperCase(Locale.ROOT), "abc");
        System.out.println(abcToUpCase);
    }

}
