package com.example;

import java.io.Serializable;

public class ResponseError  implements Serializable {
    
    private final Integer code;
    private final String message;
    
    public ResponseError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    
//    @Override
//    public String toString() {
//        return "{\"code\":\"" + getCode() + "\",\"message\":\"" + getMessage() + "\"}";
//    }
    
}