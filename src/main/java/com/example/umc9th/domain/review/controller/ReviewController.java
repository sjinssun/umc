package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.BaseSuccessCode; // BaseSuccessCode 임포트
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    //리뷰 조회
    @GetMapping
    public ApiResponse<List<ReviewResDTO.Reviewing>> getStoreReviews(
            @RequestParam(name = "storeId", required = false) Long storeId,
            @RequestParam(name = "star", required = false) Integer star) {

        // 응답 코드 정의
        BaseSuccessCode code = GeneralSuccessCode.OK;

        // 1. Service 호출
        List<ReviewResDTO.Reviewing> reviews = reviewService.searchByFilter(
                storeId,
                star
        );

        // 2. ApiResponse.onSuccess(code, result) 반환
        return ApiResponse.onSuccess(
                code,
                reviews
        );
    }
}