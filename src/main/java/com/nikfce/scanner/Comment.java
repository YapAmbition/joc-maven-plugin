package com.nikfce.scanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author shenzhencheng on 2021/12/2
 */
public class Comment {

    public static final String DEFAULT_KIND = "DefaultKind" ;
    public static final String DEFAULT_KEY = "DefaultKey" ;
    public static final String DEFAULT_VALUE = "DefaultValue" ;

    /**
     * 注释所在对象的类型
     */
    private CommentType type ;
    /**
     * 注释所在的对象名
     */
    private String target ;
    /**
     * 注释内容
     */
    private String content ;
    /**
     * 注释属性
     */
    private Map<String, Map<String, String>> attribute ;

    public CommentType getType() {
        return type;
    }

    public void setType(CommentType type) {
        this.type = type;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Map<String, String>> getAttribute() {
        return attribute;
    }

    public void setAttribute(Map<String, Map<String, String>> attribute) {
        this.attribute = attribute;
    }

    public void addAttribute(String kind, String key, String value) {
        if (attribute == null) {
            attribute = new HashMap<>() ;
        }
        attribute.putIfAbsent(kind, new HashMap<>()) ;
        attribute.get(kind).put(key, value) ;
    }

    public void removeAttribute(String kind) {
        if (attribute != null) {
            attribute.remove(kind) ;
        }
    }

    public void removeAttribute(String kind, String key) {
        Optional.ofNullable(attribute).map(a -> a.get(kind)).ifPresent(map -> map.remove(key));
    }

    public static class CommentBuilder {
        private Comment comment = new Comment() ;
        public CommentBuilder setType(CommentType type) {
            comment.setType(type);
            return this ;
        }
        public CommentBuilder setTarget(String target) {
            comment.setTarget(target);
            return this ;
        }
        public CommentBuilder setContent(String content) {
            comment.setContent(content);
            return this ;
        }
        public CommentBuilder addAttribute(String kind, String key, String value) {
            if (kind == null) kind = DEFAULT_KIND ;
            if (key == null) key = DEFAULT_KEY ;
            if (value == null) value = DEFAULT_VALUE ;
            comment.addAttribute(kind, key, value);
            return this ;
        }
        public Comment build() {
            Comment result = new Comment() ;
            result.setType(comment.getType());
            result.setTarget(comment.getTarget());
            result.setContent(comment.getContent());
            if (comment.getAttribute() != null) result.setAttribute(new HashMap<>(comment.getAttribute()));
            return result ;
        }
    }
}
