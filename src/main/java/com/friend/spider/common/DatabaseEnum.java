package com.friend.spider.common;

/**
 * fyc
 */
public enum DatabaseEnum {

    a("a"),
    b("b");;

    private String value;

    DatabaseEnum(String value) {
        this.value = value;
    }

    /** ------------------- get ------------------------- */
    public String getValue() {
        return value;
    }

}
