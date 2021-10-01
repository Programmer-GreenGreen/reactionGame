package com.example.reactionGame.mapper;

import com.example.reactionGame.dto.TestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RankingMapper {
    List<TestDto> getDayRankingList();
    List<TestDto> getTotalRankingList();


}
