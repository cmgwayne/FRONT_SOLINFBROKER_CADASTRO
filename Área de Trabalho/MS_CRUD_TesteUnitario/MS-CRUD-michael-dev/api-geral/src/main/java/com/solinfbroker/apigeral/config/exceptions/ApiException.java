package com.solinfbroker.apigeral.config.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class ApiException {
    private String mensagem;
    private HttpStatus httpStatus;
    private LocalDateTime timeStamp;

    public ApiException(String mensagem, HttpStatus httpStatus, LocalDateTime timeStamp) {
        this.mensagem = mensagem;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }
    public ApiException() {
    }


}
