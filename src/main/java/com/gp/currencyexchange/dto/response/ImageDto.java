package com.gp.currencyexchange.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class ImageDto {

    private String currency;
    private String image;

}
