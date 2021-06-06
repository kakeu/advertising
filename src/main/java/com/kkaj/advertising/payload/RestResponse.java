package com.kkaj.advertising.payload;

import lombok.Data;

import java.io.Serializable;

@Data
public class RestResponse implements Serializable {

    private Object data;
    private String message;
    private ResponseStatus status;
    private ResponseCode code;
}