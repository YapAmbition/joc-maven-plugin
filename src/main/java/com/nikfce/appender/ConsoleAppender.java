package com.nikfce.appender;

import java.io.IOException;

/**
 * @author shenzhencheng on 2021/12/3
 */
public class ConsoleAppender implements Appender {
    @Override
    public void append(String content) {
        System.out.print(content);
    }

    @Override
    public void close() throws IOException {

    }
}
