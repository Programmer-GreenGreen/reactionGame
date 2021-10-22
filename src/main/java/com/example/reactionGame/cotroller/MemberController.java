package com.example.reactionGame.cotroller;


import com.example.reactionGame.dto.MemberDto;
import com.example.reactionGame.service.MemberService;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController //rest api
@RequiredArgsConstructor
@Validated
@Slf4j
public class MemberController {

    private final MemberService memberService;


    @Operation(summary = "전체 유저를 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MemberDto.class)) }),
            @ApiResponse(responseCode = "400", description = "잘못된 값이 들어왔습니다",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "해당 유저가 존재하지 않습니다",
                    content = @Content) })
    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public List<MemberDto> getMemberList(){
        return memberService.getMemberList();
    }

    @Operation(summary = "idx 해당 유저를 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MemberDto.class)) }),
            @ApiResponse(responseCode = "400", description = "잘못된 값이 들어왔습니다",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "해당 유저가 존재하지 않습니다",
                    content = @Content) })
    @RequestMapping(value =  "/members/{idx}", method = RequestMethod.GET)
    public ResponseEntity<MemberDto> getMember(@PathVariable(name = "idx") @Valid @Min(1) Integer idx) {
        MemberDto memberDto = memberService.getMember(idx);
        return new ResponseEntity<>(memberDto, HttpStatus.OK);
    }

    @Operation(summary = "유저 정보를 입력합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "입력 성공",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MemberDto.class)) }),
            @ApiResponse(responseCode = "400", description = "잘못된 값이 들어왔습니다",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "해당 유저가 존재하지 않습니다",
                    content = @Content) })
    @RequestMapping(value =  "/members", method = RequestMethod.POST)
    public String postMember(@RequestBody MemberDto memberDto) {
        log.error(memberDto.toString());
        memberService.postMember(memberDto);
        String msg = "완료";
        return msg;
    }

    @Operation(summary ="유저 정보를 수정합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "수정 성공",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = MemberDto.class)) }),
            @ApiResponse(responseCode = "400", description = "잘못된 값이 들어왔습니다",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "해당 유저가 존재하지 않습니다",
                    content = @Content) })
    @RequestMapping(value =  "/members/{idx}", method = RequestMethod.PATCH)
    public MemberDto updateMember(@RequestBody MemberDto memberDto) {
        Integer idx = memberDto.getIdx();
        MemberDto memberDtoIdx = memberService.getMember(idx);
        memberService.updateMember(memberDto);
        return memberDtoIdx;

    }


    @Operation(summary = "idx 해당 유저를 삭제합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "삭제 성공",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "잘못된 값이 들어왔습니다",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "해당 유저가 존재하지 않습니다",
                    content = @Content) })
    @RequestMapping(value =  "/members/{idx}", method = RequestMethod.DELETE)
    public String deleteMember(@PathVariable(name = "idx") Integer idx)  {
        memberService.deleteMember(idx);
        String msg = "삭제되었습니다";
        return msg;
    }
}
