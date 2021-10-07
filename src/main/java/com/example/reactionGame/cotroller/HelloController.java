package com.example.reactionGame.cotroller;


import com.example.reactionGame.service.TestService;
import com.example.reactionGame.dto.TestDto;
import com.example.reactionGame.service.TestServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController //rest api
@RequiredArgsConstructor
@Validated
@Slf4j
public class HelloController {

    private final TestService testService;

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public Object test(){
        return "Hello World!";
    }

    @Operation(summary = "전체 유저를 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TestDto.class)) }),
            @ApiResponse(responseCode = "400", description = "잘못된 값이 들어왔습니다",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "해당 유저가 존재하지 않습니다",
                    content = @Content) })
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<TestDto> getUserList(){
        return testService.getUserList();
    }

    @Operation(summary = "idx 해당 유저를 조회합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TestDto.class)) }),
            @ApiResponse(responseCode = "400", description = "잘못된 값이 들어왔습니다",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "해당 유저가 존재하지 않습니다",
                    content = @Content) })
    @RequestMapping(value =  "/users/{idx}", method = RequestMethod.GET)
    public TestDto getUser(@PathVariable(name = "idx") @Valid @Min(1) Integer idx) {

        TestDto testDto  = testService.getUser(idx);
        return testDto;
    }

    @Operation(summary = "유저 정보를 입력합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "입력 성공",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TestDto.class)) }),
            @ApiResponse(responseCode = "400", description = "잘못된 값이 들어왔습니다",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "해당 유저가 존재하지 않습니다",
                    content = @Content) })
    @RequestMapping(value =  "/users", method = RequestMethod.POST)
    public String postUser(@RequestBody TestDto testDto) {
        log.error(testDto.toString());
        testService.postUser(testDto);
        String msg = "완료";
        return msg;
    }

    @Operation(summary ="유저 정보를 수정합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "수정 성공",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TestDto.class)) }),
            @ApiResponse(responseCode = "400", description = "잘못된 값이 들어왔습니다",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "해당 유저가 존재하지 않습니다",
                    content = @Content) })
    @RequestMapping(value =  "/users/{idx}", method = RequestMethod.PATCH)
    public TestDto updateUser(@RequestBody TestDto testDto) {
        Integer idx = testDto.getIdx();
        TestDto testDtoIdx = testService.getUser(idx);
        testService.updateUser(testDto);
        return testDtoIdx;

    }


    @Operation(summary = "idx 해당 유저를 삭제합니다")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "삭제 성공",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "잘못된 값이 들어왔습니다",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "해당 유저가 존재하지 않습니다",
                    content = @Content) })
    @RequestMapping(value =  "/users/{idx}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable(name = "idx") Integer idx)  {
        testService.deleteUser(idx);
        String msg = "삭제되었습니다";
        return msg;
    }
}
