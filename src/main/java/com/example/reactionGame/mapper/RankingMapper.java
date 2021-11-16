package com.example.reactionGame.mapper;

import com.example.reactionGame.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RankingMapper {
    List<MemberDto> getWeekRankingList();
    /*List<MemberDto> getTotalRankingList();*/
    MemberDto getMemberPercent(Integer idx);


}
