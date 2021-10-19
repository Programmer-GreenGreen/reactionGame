package com.example.reactionGame.service;

import com.example.reactionGame.dto.MemberDto;

import java.util.List;

public interface RankingService {

    List<MemberDto> getToDayRanking();
    List<MemberDto> getTotalDayRanking();

}
