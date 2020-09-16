package com.mjc.own.common;

/**
 * Created by gcb on 2019/4/2.
 */
public enum LogEnum {
    BUSSINESS("bussiness"),
    PLATFORM("platform"),
    DB("db"),
    EXCEPTION("exception"),
            ;

    private String category;

    LogEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
