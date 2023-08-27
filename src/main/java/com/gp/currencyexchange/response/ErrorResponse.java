package com.gp.currencyexchange.response;
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