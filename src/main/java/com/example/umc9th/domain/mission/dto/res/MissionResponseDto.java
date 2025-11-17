package com.example.umc9th.domain.mission.dto.res;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class MissionResponseDto {
    public static class ChallengeResultDto{
        private Long userMissionId;
        private Long missionid;
        private String missionTitle;
        private String status;
        private LocalDateTime createdAt;
    }
}
