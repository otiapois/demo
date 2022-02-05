package com.fouo.design.structural.adapter.obj;

import com.fouo.design.structural.adapter.Player;
import com.fouo.design.structural.adapter.Translator;
import com.fouo.design.structural.adapter.Zh_JpTranslator;

/**
 * 日本电影播放器适配器
 * 第二种模式 通过组合的方式  将两个不相关的接口适配起来一起使用
 * 增强一个类，连接两个类
 * @author fouo
 * @date 2022/2/2 14:47
 */
public class JPMoviePlayerAdaptor  implements Player {
    private Player target;//被适配对象
    private Translator translator;
    public JPMoviePlayerAdaptor(Player target,Translator translator) {
        this.target = target;
        this.translator = translator;
    }

    @Override
    public String play() {
        String content = target.play();
        String jpContent = translator.translate(content);
        System.out.println(jpContent);
        return jpContent;
    }
}
