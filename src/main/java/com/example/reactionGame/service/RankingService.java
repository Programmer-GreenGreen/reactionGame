package com.example.reactionGame.service;

import com.example.reactionGame.dto.MemberDto;

import java.util.List;
/***
 * RankingService
 * @author Lee
 */
public interface RankingService {

    List<MemberDto> getWeekRankingList();
    /*List<MemberDto> getTotalDayRanking();*/
    MemberDto getMemberPercent(Integer idx);
}
