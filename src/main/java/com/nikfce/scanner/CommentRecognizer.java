package com.nikfce.scanner;

/**
 * 实现多个Recognizer,要实现所有的com.sun.source.doctree.DocTree.Kind下面枚举的所有注释
 * @author shenzhencheng on 2021/12/3
 */
public interface CommentRecognizer {

    String tag() ;

    Triple recognize(String comment) ;

}
