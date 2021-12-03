package com.nikfce.doclet;

import com.sun.javadoc.ClassDoc;

/**
 * @author shenzhencheng on 2021/12/2
 */
@FunctionalInterface
public interface JocletCallback {

    void callback(ClassDoc[] classes) ;

}
