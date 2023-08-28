package com.gp.currencyexchange.web.response;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ErrorResponse implements Serializable {
    private int statusCode;
    private String message;
}