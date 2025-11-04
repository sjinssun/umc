package com.example.umc9th.domain.review.repository;

import com.example.umc9th.domain.review.dto.ReviewDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
// QueryDSL 구현 메서드를 정의하는 인터페이스
public interface ReviewRepositorySearch{
    Page<ReviewDetailDto> findReviewsByStoreIdAndStarRange(
            Long storeId,
            Integer starRating,
            Pageable pageable
    );
}