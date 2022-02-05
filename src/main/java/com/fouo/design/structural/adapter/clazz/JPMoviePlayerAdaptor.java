package com.fouo.design.structural.adapter.clazz;

import com.fouo.design.structural.adapter.Player;
import com.fouo.design.structural.adapter.Translator;
import com.fouo.design.structural.adapter.Zh_JpTranslator;

/**
 * 日本电影播放器适配器
 * 第一种模式 通过继承的模式，适配转换到了翻译器的功能上
 * 将两个不相关的接口适配起来一起使用
 * @author fouo
 * @date 2022/2/2 14:47
 */
public class JPMoviePlayerAdaptor implements Player, Translator {
    private Player target;//被适配对象
    private Translator translator;
    public JPMoviePlayerAdaptor(Player target,Translator taTranslator) {
        this.target = target;
        this.translator = taTranslator;
    }

    @Override
    public String play() {
        String content = target.play();
        String jpContent = translate(content);
        System.out.println(jpContent);
        return jpContent;
    }

    @Override
    public String translate(String content) {
        return translator.translate(content);
    }
}
