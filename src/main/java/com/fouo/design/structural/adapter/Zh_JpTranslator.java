package com.fouo.design.structural.adapter;

import java.util.Objects;

/**
 * 翻译器类
 *
 * @author fouo
 * @date 2022/2/2 14:57
 */
public class Zh_JpTranslator implements Translator{

    @Override
    public String translate(String content) {
        if(Objects.equals("hello world", content)){
            return "纳尼 八嘎";
        }
        return "******";
    }
}
