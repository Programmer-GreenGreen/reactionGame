package com.example.reactionGame.service;

import com.example.reactionGame.dto.MemberDto;
import com.example.reactionGame.mapper.RankingMapper;
import com.example.reactionGame.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {

    private final RankingMapper mapper;
    private final MemberMapper memberMapper;

    @Override
    public List<MemberDto> getToDayRanking() {
        memberMapper.getUserList();
        return mapper.getDayRankingList();
    }

    @Override
    public List<MemberDto> getTotalDayRanking() {
        return mapper.getTotalRankingList();
    }
}
