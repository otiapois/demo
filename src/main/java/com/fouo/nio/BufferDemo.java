package com.fouo.nio;

import java.nio.Buffer;
import java.nio.IntBuffer;

/**
 * nio  非阻塞io
 * buffer
 *
 * @author fouo
 * @date 2020/11/17 16:42
 */
public class BufferDemo {
    public static void main(String[] args) {

        IntBuffer buffer = IntBuffer.allocate(2);
        buffer.put(1);
        buffer.put(2);
        System.out.println(buffer.capacity());
        //读写切换
//        buffer.flip();
        System.out.println(buffer.hasRemaining()+"      buffer     "+buffer.get());
        System.out.println(buffer.hasRemaining()+"      buffer     "+buffer.get());
    }
}
