package com.nikfce.appender;

import java.io.Closeable;

/**
 * @author shenzhencheng on 2021/12/2
 */
public interface Appender extends Closeable {

    void append(String content) ;

}
