package com.fouo.design.structural.adapter.obj;

import com.fouo.design.structural.adapter.MoviePlayer;
import com.fouo.design.structural.adapter.Zh_JpTranslator;

/**
 * 适配器测试类
 *
 * @author fouo
 * @date 2022/2/2 14:48
 */
public class AdapterTest {
    public static void main(String[] args) {
        MoviePlayer moviePlayer = new MoviePlayer();
        Zh_JpTranslator translator = new Zh_JpTranslator();
        JPMoviePlayerAdaptor adaptor = new JPMoviePlayerAdaptor(moviePlayer,translator);
        adaptor.play();
    }
}
