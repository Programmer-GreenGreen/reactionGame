package com.example.reactionGame.service;

import com.example.reactionGame.dto.TestDto;
import com.example.reactionGame.mapper.RankingMapper;
import com.example.reactionGame.mapper.TestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RankingServiceImpl implements RankingService {

    private final RankingMapper mapper;
    private final TestMapper testMapper;

    @Override
    public List<TestDto> getToDayRanking() {
        testMapper.getUserList();
        return mapper.getDayRankingList();
    }

    @Override
    public List<TestDto> getTotalDayRanking() {
        return mapper.getTotalRankingList();
    }
}
