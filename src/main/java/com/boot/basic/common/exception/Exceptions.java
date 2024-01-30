package com.boot.basic.common.exception;

public enum Exceptions {
    PRODUCT("Product"),
    ORDER("Order"),
    PROVIDER("Provider");

    private String exceptions;

    Exceptions(String exceptions){
        this.exceptions = exceptions;
    }

    public String getExceptions() {
        return exceptions;
    }

    @Override
    public String toString() {
        return getExceptions() + " Exception. ";
    }
}
