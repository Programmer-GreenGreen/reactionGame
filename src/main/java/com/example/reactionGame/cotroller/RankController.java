package com.example.reactionGame.cotroller;

import com.example.reactionGame.dto.MemberDto;
import com.example.reactionGame.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RankController {
    private final RankingService rankingService;


    @GetMapping(value = "/users/rank")
    public List<MemberDto> getDayRankingList(){

        return rankingService.getToDayRanking();
    }

    @GetMapping(value = "/users/total-rank")
    public  List<MemberDto> getTotalRankingList(){
        return rankingService.getTotalDayRanking();
    }

}
