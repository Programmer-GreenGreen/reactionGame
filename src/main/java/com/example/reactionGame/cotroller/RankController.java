package com.example.reactionGame.cotroller;

import com.example.reactionGame.dto.MemberDto;
import com.example.reactionGame.service.RankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RankController {
    private final RankingService rankingService;


    @GetMapping(value = "/members/rank")
    public List<MemberDto> getWeekRankingList() {

        return rankingService.getWeekRankingList();
    }

    @GetMapping(value = "/members/{idx}/percent")
    public ResponseEntity<MemberDto> getMemberPercent(@PathVariable(name = "idx") @Valid @Min(1) Integer idx) {
        MemberDto memberDto = rankingService.getMemberPercent(idx);
        return new ResponseEntity(memberDto, HttpStatus.OK);
    }
}

