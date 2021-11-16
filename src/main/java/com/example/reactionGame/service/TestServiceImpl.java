package com.example.reactionGame.service;

import com.example.reactionGame.mapper.TestMapper;
import com.example.reactionGame.dto.TestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService{

    private final TestMapper testMapper;


    @Override
    public List<TestDto> getUserList() {
        return testMapper.getUserList();
    }


    @Override
    public TestDto getUser(Integer idx) {
        return testMapper.getUser(idx);
    }

    @Override
    public void postUser(TestDto testDto) {
        testMapper.postUser(testDto);
    }

    @Override
    public void deleteUser(Integer idx) {
        testMapper.deleteUser(idx);
    }

    @Override
    public TestDto updateUser(TestDto testDto) {
        TestDto testDto1 =  testMapper.getUser(testDto.getIdx());
        return testMapper.updateUser(testDto1);
    }
}
