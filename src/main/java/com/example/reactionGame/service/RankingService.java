package com.example.reactionGame.service;

import com.example.reactionGame.dto.TestDto;

import java.util.List;

public interface RankingService {

    List<TestDto> getToDayRanking();
    List<TestDto> getTotalDayRanking();

}
