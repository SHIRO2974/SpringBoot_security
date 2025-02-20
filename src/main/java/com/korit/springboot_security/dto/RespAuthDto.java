package com.korit.springboot_security.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespAuthDto {
    private String accessToken;
    private String refreshToken;
}
