package com.purpleio.oembedproject.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UrlDto {
    @NotEmpty(message = "Url을 입력해주세요.")
    private String url;
}
