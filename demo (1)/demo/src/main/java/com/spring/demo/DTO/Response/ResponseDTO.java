package com.spring.demo.DTO.Response;

import com.spring.demo.pojos.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ResponseDTO {

    @Setter
    @Getter
    class Header{
        private int status_code;
    }

    @Setter
    @Getter
    class Body{
        private Object data;
    }

    @Setter
    @Getter
    class Error{
        private String messenger;
    }

    private Header header = new Header();
    private Body body = new Body();
    private Error error = new Error();

    public ResponseDTO(int code, Object obj){
        setHeader(code);
        setData(obj);
    }

    public void setHeader(int code){
        this.header.setStatus_code(code);
    }

    public void setData(Object obj){
        this.body.setData(obj);
    }

    public void setError(String error){
        this.error.setMessenger(error);
    }
}
