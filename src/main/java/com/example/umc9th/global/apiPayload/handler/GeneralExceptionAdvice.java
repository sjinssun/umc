package com.example.umc9th.global.apiPayload.handler;

import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.code.GeneralErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionAdvice {

    // 1. GeneralException 및 ReviewException 같은 비즈니스 예외를 처리
    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ApiResponse<Object>> handleGeneralException(GeneralException ex) {

        BaseErrorCode errorCode = ex.getErrorCode();

        // 예외가 가진 HTTP 상태 코드와, ApiResponse의 onFailure 메서드를 사용하여 응답 생성
        return ResponseEntity.status(errorCode.getStatus())
                .body(ApiResponse.onFailure(
                        errorCode,
                        null
                ));
    }

    // 2. 그 외의 모든 예상치 못한 서버 내부 오류(500 에러)를 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception ex) {

        // 내부 오류 코드를 가져옵니다.
        BaseErrorCode code = GeneralErrorCode.INTERNAL_SERVER_ERROR;

        return ResponseEntity.status(code.getStatus())
                .body(ApiResponse.onFailure(
                        code,
                        null
                ));
    }
}