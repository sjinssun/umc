package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import com.example.umc9th.domain.review.dto.res.ReviewResDTO; // DTO import
import com.example.umc9th.domain.review.converter.ReviewConverter; // Converter import

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {
    private final ReviewRepository reviewRepository;

    // 1. 메서드 반환 타입을 DTO 리스트로 변경합니다.
    public List<ReviewResDTO.Reviewing> searchByFilter(
            Long storeId, Integer star) {

        // 2. Repository에서 엔티티 리스트를 조회합니다.
        List<Review> reviewList = reviewRepository.findReviewsByStoreIdAndStarRange(storeId, star);

        // 3.Converter를 사용하여 엔티티 리스트를 DTO 리스트로 변환하여 반환합니다.
        return ReviewConverter.toReviewingList(reviewList);

    }
}