package com.example.umc9th.domain.user.dto;


import com.example.umc9th.domain.user.enums.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyPageUserDto {
    // User.name
    private String username;

    // User.addres
    private Address address;

    // User.userPoint
    private Long userPoint;

    // COUNT(r.review_id)
    private Long reviewCount;
}
