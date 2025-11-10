package com.example.umc9th.domain.review.controller;

import com.example.umc9th.domain.review.dto.res.ReviewResDTO;
import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.service.ReviewService;
import com.example.umc9th.global.apiPayload.ApiResponse;
import com.example.umc9th.global.apiPayload.code.GeneralSuccessCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ApiResponse<List<ReviewResDTO.Reviewing>> getStoreReviews(
            @RequestParam(name = "storeId", required = false) Long storeId,
            @RequestParam(name = "star", required = false) Integer star) {

        // 1. Service 호출 (DTO 리스트 반환)
        List<ReviewResDTO.Reviewing> reviews = reviewService.searchByFilter(
                storeId,
                star
        );

        // 2. ApiResponse.onSuccess()를 사용하여 성공 응답 반환
        return ApiResponse.onSuccess(reviews);
    }// GeneralSuccessCode.OK를 기본으로 사용
}