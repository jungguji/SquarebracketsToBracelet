package com.ji.junggu.bracelet.global;

public enum BracketType {
    BIG("[", "]"),
    MEDIUM("{", "}");

    private String left;
    private String right;

    BracketType(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public String getLeft() {
        return this.left;
    }

    public String getRight() {
        return this.right;
    }
}