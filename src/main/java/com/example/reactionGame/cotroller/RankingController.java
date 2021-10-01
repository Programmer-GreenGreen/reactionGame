package com.example.reactionGame.cotroller;

import com.example.reactionGame.dto.TestDto;
import com.example.reactionGame.service.RankingService;
import com.example.reactionGame.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RankingController {

    private final RankingService rankingService;

    @GetMapping(value = "/users/rank")
    public List<TestDto> getDayRankingList(){
        return rankingService.getToDayRanking();
    }

    @GetMapping(value = "/users/totalrank")
    public  List<TestDto> getTotalRankingList(){
        return rankingService.getTotalDayRanking();
    }
}
