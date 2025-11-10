package com.example.umc9th.domain.review.exception; // ⭐️ 새 패키지

import com.example.umc9th.global.apiPayload.code.BaseErrorCode;
import com.example.umc9th.global.apiPayload.exception.GeneralException;

public class ReviewException extends GeneralException {

    public ReviewException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}