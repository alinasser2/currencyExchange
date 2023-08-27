package com.gp.currencyexchange.response;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private String message;
}