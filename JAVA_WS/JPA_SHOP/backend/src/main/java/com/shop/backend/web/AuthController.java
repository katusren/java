package com.shop.backend.web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.shop.backend.config.JwtTokenProvider;
import com.shop.backend.service.MemberService;
import com.shop.backend.web.dto.MemberDto;

//Spring Boot 기반의 JWT 인증 시스템에서 회원가입/로그인/사용자 정보 조회 및 수정 기능을 제공

@Tag(name = "인증", description = "회원가입 및 로그인 API")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;
    private final JwtTokenProvider jwtTokenProvider;

    @Operation(summary = "회원가입", description = "새로운 사용자를 등록합니다.")
    @PostMapping("/signup")
    public ResponseEntity<MemberDto.MemberResponse> signUp(@Valid @RequestBody MemberDto.SignUpRequest request) {
        MemberDto.MemberResponse response = memberService.signUp(request);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "로그인", description = "사용자 로그인을 처리합니다.")
    @PostMapping("/login")
    public ResponseEntity<MemberDto.LoginResponse> login(@Valid @RequestBody MemberDto.LoginRequest request) {
        MemberDto.LoginResponse loginResponse = memberService.login(request);

        // JWT 토큰 생성
        String token = jwtTokenProvider.generateToken(loginResponse.getUsername());
        loginResponse.setToken(token);

        return ResponseEntity.ok(loginResponse);
    }

    @Operation(summary = "사용자 정보 조회", description = "현재 로그인한 사용자의 정보를 조회합니다.")
    @GetMapping("/me")
    public ResponseEntity<MemberDto.MemberResponse> getMyInfo(@RequestHeader("Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);
            if (jwtTokenProvider.validateToken(jwt)) {
                String username = jwtTokenProvider.getUsernameFromToken(jwt);
                MemberDto.MemberResponse response = memberService.getMemberInfo(username);
                return ResponseEntity.ok(response);
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @Operation(summary = "사용자 정보 수정", description = "현재 로그인한 사용자의 정보를 수정합니다.")
    @PutMapping("/me")
    public ResponseEntity<MemberDto.MemberResponse> updateMyInfo(
            @RequestHeader("Authorization") String token,
            @Valid @RequestBody MemberDto.UpdateRequest request) {
        if (token != null && token.startsWith("Bearer ")) {
            String jwt = token.substring(7);
            if (jwtTokenProvider.validateToken(jwt)) {
                String username = jwtTokenProvider.getUsernameFromToken(jwt);
                MemberDto.MemberResponse response = memberService.updateMember(username, request);
                return ResponseEntity.ok(response);
            }
        }
        return ResponseEntity.badRequest().build();
    }
}