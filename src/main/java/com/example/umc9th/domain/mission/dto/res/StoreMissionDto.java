package com.example.umc9th.domain.mission.dto.res;


import lombok.Builder;

import java.time.LocalDateTime;

@Builder
// @Getter, @Setter, @NoArgsConstructor, @AllArgsConstructor는 record가 자동으로 처리합니다.
public record StoreMissionDto(
    Long missionId,
    String title,
    String description, //Mission.content
    Long rewardPoints, //Mission.point
    LocalDateTime deadline
    ) {

    }
