package com.nikfce.scanner;

/**
 * @author shenzhencheng on 2021/12/3
 */
public class SinceCommentRecognizer extends BaseCommentRecognizer {
    @Override
    public String tag() {
        return "@since";
    }

    @Override
    public Triple recognize(String comment) {
        return new Triple(tag(), Comment.DEFAULT_KEY, comment) ;
    }
}
