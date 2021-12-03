package com.nikfce.scanner;

import com.alibaba.fastjson.JSON;
import com.nikfce.doclet.Joclet;
import com.sun.javadoc.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shenzhencheng on 2021/12/2
 */
public class CommentScanner implements Scanner<Comment> {

    public static void main(String[] args) {
        File file = new File("/Users/shenzhencheng/Documents/ali-repository/dal-console-java/src/main/java/me/ele/dal/console/service/job/automatic/ResourceApplyJob.java") ;
        Scanner<Comment> scanner = new CommentScanner() ;
        List<Comment> commentList = scanner.scan(file) ;
        System.out.println(JSON.toJSONString(commentList));
    }

    @Override
    public List<Comment> scan(File file) {
        List<Comment> result = new ArrayList<>();
        Joclet.execute(file.getAbsolutePath(), classes -> result.addAll(extractComment(classes)));
        return result ;
    }

    /**
     * 从Doclet返回的结果中提取注释对象
     * @param classDocs Doclet返回的类注释对象
     * @return 注释对象列表
     */
    private List<Comment> extractComment(ClassDoc[] classDocs) {
        List<Comment> result = new ArrayList<>() ;
        for (ClassDoc classDoc : classDocs) {
            // class
            result.addAll(handleClassDoc(classDoc)) ;
            // property,filter=false表示包含private的filed
            FieldDoc[] fieldDocs = classDoc.fields(false) ;
            for (FieldDoc fieldDoc : fieldDocs) {
                result.addAll(handleFieldDoc(fieldDoc)) ;
            }
            // method
            MethodDoc[] methodDocs = classDoc.methods(false) ;
            for (MethodDoc methodDoc : methodDocs) {
                result.addAll(handleMethodDoc(methodDoc)) ;
            }
        }
        return result ;
    }

    /**
     * 解析类上的注释
     * @param classDoc 类的文档对象
     * @return 注释对象
     */
    private List<Comment> handleClassDoc(ClassDoc classDoc) {
        List<Comment> result = new ArrayList<>() ;
        Comment.CommentBuilder classCommentBuilder = new Comment.CommentBuilder()
                .setType(CommentType.CLASS)
                .setTarget(classDoc.name())
                .setContent(classDoc.commentText());
        for (Tag tag : classDoc.tags()) {
            Triple triple = CommentRecognizerDispatcher.getInstance().recognize(tag.name(), tag.toString()) ;
            if (triple != null) classCommentBuilder.addAttribute(triple.getTag(), triple.getKey(), triple.getValue()) ;
        }
        result.add(classCommentBuilder.build()) ;
        return result ;
    }

    /**
     * 解析属性上的注释
     * @param fieldDoc 属性的文档对象
     * @return 注释对象
     */
    private List<Comment> handleFieldDoc(FieldDoc fieldDoc) {
        List<Comment> result = new ArrayList<>() ;
        Comment.CommentBuilder filedCommentBuilder = new Comment.CommentBuilder()
                .setType(CommentType.PROPERTY)
                .setTarget(fieldDoc.name())
                .setContent(fieldDoc.commentText()) ;

        for (Tag tag : fieldDoc.tags()) {
            Triple triple = CommentRecognizerDispatcher.getInstance().recognize(tag.name(), tag.toString()) ;
            if (triple != null) filedCommentBuilder.addAttribute(triple.getTag(), triple.getKey(), triple.getValue()) ;
        }
        result.add(filedCommentBuilder.build()) ;
        return result ;
    }

    /**
     * 解析方法伤的注释
     * @param methodDoc 方法的文档对象
     * @return 注释对象
     */
    private List<Comment> handleMethodDoc(MethodDoc methodDoc) {
        List<Comment> result = new ArrayList<>() ;
        Comment.CommentBuilder methodCommentBuilder = new Comment.CommentBuilder()
                .setType(CommentType.METHOD)
                .setTarget(methodDoc.name())
                .setContent(methodDoc.commentText()) ;
        for (Tag tag : methodDoc.tags()) {
            Triple triple = CommentRecognizerDispatcher.getInstance().recognize(tag.name(), tag.text()) ;
            if (triple != null) methodCommentBuilder.addAttribute(triple.getTag(), triple.getKey(), triple.getValue()) ;
        }
        result.add(methodCommentBuilder.build()) ;
        return result ;
    }

}
