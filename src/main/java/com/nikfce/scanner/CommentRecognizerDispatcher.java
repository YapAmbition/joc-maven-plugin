package com.nikfce.scanner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shenzhencheng on 2021/12/3
 */
public class CommentRecognizerDispatcher {

    private static final CommentRecognizerDispatcher INSTANCE = new CommentRecognizerDispatcher() ;

    private List<CommentRecognizer> commentRecognizerList = new ArrayList<>() ;

    private CommentRecognizerDispatcher() {
        commentRecognizerList.add(new ParamCommentRecognizer()) ;
        commentRecognizerList.add(new AuthorCommentRecognizer()) ;
        commentRecognizerList.add(new DeprecatedCommentRecognizer()) ;
        commentRecognizerList.add(new LinkCommentRecognizer()) ;
        commentRecognizerList.add(new LinkPlainCommentRecognizer()) ;
        commentRecognizerList.add(new ReturnCommentRecognizer()) ;
        commentRecognizerList.add(new SeeCommentRecognizer()) ;
        commentRecognizerList.add(new SerialCommentRecognizer()) ;
        commentRecognizerList.add(new SinceCommentRecognizer()) ;
        commentRecognizerList.add(new ThrowsCommentRecognizer()) ;
        commentRecognizerList.add(new ValueCommentRecognizer()) ;
        commentRecognizerList.add(new VersionCommentRecognizer()) ;
    }

    public static CommentRecognizerDispatcher getInstance() {
        return INSTANCE ;
    }

    public Triple recognize(String tag, String comment) {
        for (CommentRecognizer commentRecognizer : commentRecognizerList) {
            if (commentRecognizer.tag().equals(tag)) {
                return commentRecognizer.recognize(comment) ;
            }
        }
        return null ;
    }

}
