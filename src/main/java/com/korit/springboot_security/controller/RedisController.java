package com.korit.springboot_security.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.springboot_security.dto.Req.Redis.ReqRedisDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/api/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/json")
    public ResponseEntity<?> jsonGet(@RequestBody String key) throws JsonProcessingException {

        String value =  redisTemplate.opsForValue().get(key).toString();    // Object 자료형이기 때문에 toString 사용
        ReqRedisDto reqRedisDto = objectMapper.readValue(value, ReqRedisDto.class);
        return ResponseEntity.ok(reqRedisDto);
    }


    @PostMapping("/{key}/{value}")
    public ResponseEntity<?> set(@PathVariable String key, @PathVariable String value) {

        redisTemplate.opsForValue().set(key, value, Duration.ofSeconds(68));    // 문자열 저장
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{key}")
    public ResponseEntity<?> get(@PathVariable String key) {

        String value =  redisTemplate.opsForValue().get(key).toString();
        return ResponseEntity.ok().build();
    }

}
