package com.nikfce.scanner;

/**
 * @author shenzhencheng on 2021/12/3
 */
public abstract class BaseCommentRecognizer implements CommentRecognizer {

    /**
     * 基本三元组的注释,通过空格来分割
     * @param comment 传入的注释
     * @return 三元组
     */
    @Override
    public Triple recognize(String comment) {
        String[] comments = comment.split(" ") ;
        String param = null, value = null ;
        if (comments.length == 1) {
            param = comments[0].trim() ;
            value = Comment.DEFAULT_VALUE ;
        } else if (comments.length > 1) {
            param = comments[0].trim() ;
            value = comment.substring(comment.indexOf(comments[1])).trim() ;
        }
        return new Triple(tag(), param, value) ;
    }
}
