package com.nikfce.scanner;

/**
 * 解析@param
 * @author shenzhencheng on 2021/12/3
 */
public class ParamCommentRecognizer extends BaseCommentRecognizer {

    @Override
    public String tag() {
        return "@param";
    }

}
