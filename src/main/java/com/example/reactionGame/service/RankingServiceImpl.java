package com.example.reactionGame.service;

import com.example.reactionGame.dto.MemberDto;
import com.example.reactionGame.mapper.RankingMapper;
import com.example.reactionGame.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class RankingServiceImpl implements RankingService {

    private final RankingMapper RankingMapper;
    private final MemberMapper memberMapper;

    @Override
    public List<MemberDto> getWeekRankingList() {
        memberMapper.getMemberList();
        return RankingMapper.getWeekRankingList();
    }

    @Override
    public MemberDto getMemberPercent(Integer idx) {

    return  RankingMapper.getMemberPercent(idx);

    }

    /*@Override
    public List<MemberDto> getTotalDayRanking() {
        return mapper.getTotalRankingList();
    }*/
}
