package com.nikfce.scanner;

/**
 * @author shenzhencheng on 2021/12/3
 */
public class ExceptionCommentRecognizer extends BaseCommentRecognizer {
    @Override
    public String tag() {
        return "@exception";
    }
}
