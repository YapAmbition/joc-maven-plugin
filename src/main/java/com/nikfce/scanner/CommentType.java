package com.nikfce.scanner;

/**
 * @author shenzhencheng on 2021/12/2
 */
public enum CommentType {

    METHOD("METHOD"),
    CLASS("CLASS"),
    PROPERTY("PROPERTY")
    ;

    private String value ;

    CommentType(String value) {
        this.value = value ;
    }

    public String getValue() {
        return value;
    }
}
