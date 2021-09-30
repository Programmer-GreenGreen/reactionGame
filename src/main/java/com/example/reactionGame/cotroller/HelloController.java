package com.example.reactionGame.cotroller;


import com.example.reactionGame.service.TestService;
import com.example.reactionGame.dto.TestDto;
import com.example.reactionGame.service.TestServiceImpl;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //rest api
@RequiredArgsConstructor
@Slf4j
public class HelloController {

    private final TestService testService;
    private final TestServiceImpl a;

    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public Object test(){
        return "Hello World!";
    }



    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<TestDto> getUserList(){
        return testService.getUserList();
    }

    @RequestMapping(value =  "/users/{idx}", method = RequestMethod.GET)
    public TestDto getUser(@PathVariable(name = "idx") Integer idx) {
        log.error("idx : " + idx);
        TestDto testDto  = testService.getUser(idx);
        System.out.println(testDto.toString());
        return testDto;
    }

    @RequestMapping(value =  "/users", method = RequestMethod.POST)
    public String postUser(@RequestBody TestDto testDto) {

        log.error(testDto.toString());
        testService.postUser(testDto);
        String msg = "완료";
        return msg;
    }

    @RequestMapping(value =  "/users/{idx}", method = RequestMethod.PATCH)

    public TestDto updateUser(@RequestBody TestDto testDto) {
        Integer idx = testDto.getIdx();
        TestDto testDto1 = testService.getUser(idx);
        testService.updateUser(testDto);
        return testDto1;

    }


    @RequestMapping(value =  "/users/{idx}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable(name = "idx") Integer idx)  {
        testService.deleteUser(idx);
        String msg = "삭제되었습니다";
        return msg;
    }
}
