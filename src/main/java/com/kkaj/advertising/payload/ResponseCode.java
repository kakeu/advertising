package com.kkaj.advertising.payload;

import org.springframework.lang.Nullable;

public enum ResponseCode {

    OK(200,"Ok"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTED(501, "Not Implemented"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    BAD_REQUEST(400, "Bad Request"),
    INVALID_RESPONSE_FORMAT(407,"Invalid Response Format"),
    TRANSACTION_SUCCESSFUL(200, "Transaction successful"),
    NOk(410,"NOK");

    private int code;
    private String description;

    ResponseCode(int code, String description){
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static ResponseCode evalFromInt(int statusCode) {
        ResponseCode status = resolve(statusCode);
        if(status == null) {
            return resolve(406);
        } else {
            return status;
        }
    }

    @Nullable
    public static ResponseCode resolve(int statusCode) {
        ResponseCode[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ResponseCode status = var1[var3];
            if(status.code == statusCode) {
                return status;
            }
        }

        return null;
    }

    @Override
    public String toString(){
        return ""+this.getCode();
    }
}
