package com.example.umc9th.domain.review.service;

import com.example.umc9th.domain.review.entity.Review;
import com.example.umc9th.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<Review> SearchByFilter(
            Long storeId, Integer star) {
        // Repository의 간단한 메서드를 호출하여 List<Review>를 반환합니다.
        return reviewRepository.findReviewsByStoreIdAndStarRange(storeId, star);
    }
}