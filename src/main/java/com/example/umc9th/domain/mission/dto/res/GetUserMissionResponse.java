package com.example.umc9th.domain.mission.dto.res;

public record GetUserMissionResponse(
        Long missionId,
        String content,
        Long point,
        String restaurantName,
        Boolean isCompleted
) {}
