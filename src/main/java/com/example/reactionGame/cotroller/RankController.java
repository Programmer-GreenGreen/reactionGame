package com.example.reactionGame.cotroller;

import com.example.reactionGame.dto.MemberDto;
import com.example.reactionGame.service.RankingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@Slf4j
public class RankController {
    private final RankingService rankingService;

    @Operation(summary = "일주일간 랭킹을 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "잘못된 값이 들어왔습니다",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "서버 오류 입니다",
                    content = @Content) })
    @GetMapping(value = "/members/rank")
    public List<MemberDto> getWeekRankingList() {

        return rankingService.getWeekRankingList();
    }

    @Operation(summary = "해당유저의 상위 %를 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "잘못된 값이 들어왔습니다",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "해당 유저가 존재하지 않습니다",
                    content = @Content) })
    @GetMapping(value = "/members/{idx}/percent")
    public ResponseEntity<MemberDto> getMemberPercent(@PathVariable(name = "idx") @Valid @Min(1) Integer idx) {
        MemberDto memberDto = rankingService.getMemberPercent(idx);
        return new ResponseEntity(memberDto, HttpStatus.OK);
    }
//
//    @GetMapping(value = "members/percent")
//    public Integer getPercent() {
//        Integer percent = MemberDto
//        return percent;
//    }
}

