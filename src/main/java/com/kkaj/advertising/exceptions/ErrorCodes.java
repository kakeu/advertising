package com.kkaj.advertising.exceptions;

public enum ErrorCodes {

    LISTING_NOT_FOUND(1000),
    LISTING_NOT_VALID(1001),
    CATEGORY_NOT_FOUND(2000),
    CATEGORY_NOT_VALID(2001),
    VOITURE_NOT_FOUND(3000),
    VOITURE_NOT_VALID(3500),
    CONCESSIONAIRE_NOT_FOUND(4000),
    CONCESSIONAIRE_NOT_VALID(4001),

    ;

    private final int code;
   // private final String message;

    ErrorCodes(int code){
        this.code = code;
        //this.message = message;
    }

    public int getCode(){
        return code;
    }

 /*   public String getMessage(){
        return message;
    }*/
}
