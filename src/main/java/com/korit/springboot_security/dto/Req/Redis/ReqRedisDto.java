package com.korit.springboot_security.dto.Req.Redis;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "Redis Study Dto")
public class ReqRedisDto {

    @Schema(description = "키값", example = "key1")
    private String key;

    @Schema(description = "데이터값", example = "value1")
    private String value;

    @Schema(description = "데이터값 리스트", example = "[1, 2, 3]]")
    private List<Integer> values;
}
