package com.korit.springboot_security.dto.Req.auth;

import lombok.Data;

@Data
public class ReqSignInDto {

    private String username;
    private String password;
}
