package com.example.umc9th.domain.mission.converter;


import com.example.umc9th.domain.mission.dto.res.MissionResponseDto;
import com.example.umc9th.domain.mission.dto.res.StoreMissionDto;
import com.example.umc9th.domain.mission.entity.Mission;
import com.example.umc9th.domain.user.entity.User;
import com.example.umc9th.domain.user.entity.UserMission;

import java.util.List;
import java.util.stream.Collectors;

public class MissionConverter {

    public static UserMission toUserMission(User user, Mission mission) {
        return UserMission.builder()
                .user(user)
                .mission(mission)
                .status(false) // false: 진행 중 (도전 시작)
                .build();
    }

    public static MissionResponseDto.ChallengeResultDto toChallengeResultDto(UserMission userMission) {
        return MissionResponseDto.ChallengeResultDto.builder()
                .userMissionId(userMission.getId())
                .missionId(userMission.getMission().getId())
                .missionTitle(userMission.getMission().getTitle())
                .status("도전 중")
                .createdAt(userMission.getCreatedAt())
                .build();
    }

    // [API 2] Mission Entity List를 StoreMissionDto List로 변환
    public static List<StoreMissionDto> toStoreMissionDtoList(List<Mission> missionList) {
        return missionList.stream()
                .map(MissionConverter::toStoreMissionDto)
                .collect(Collectors.toList());
    }

    // Mission Entity 하나를 DTO로 변환
    public static StoreMissionDto toStoreMissionDto(Mission mission) {
        return StoreMissionDto.builder()
                .missionId(mission.getId())
                .title(mission.getTitle())
                .description(mission.getContent()) // Mission 엔티티 필드 매핑
                .rewardPoints(mission.getPoint())
                .deadline(mission.getDeadline())
                .build();
    }
}