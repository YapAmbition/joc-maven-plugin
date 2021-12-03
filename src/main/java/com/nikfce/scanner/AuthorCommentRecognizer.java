package com.nikfce.scanner;

/**
 * @author shenzhencheng on 2021/12/3
 */
public class AuthorCommentRecognizer extends BaseCommentRecognizer {
    @Override
    public String tag() {
        return "@author";
    }

    @Override
    public Triple recognize(String comment) {
        return new Triple(tag(), Comment.DEFAULT_KEY, comment.startsWith(tag()) ? comment.substring(tag().length()) : comment) ;
    }
}
