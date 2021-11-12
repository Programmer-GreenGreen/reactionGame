package com.example.reactionGame.service;

import com.example.reactionGame.dto.TestDto;

import java.util.List;

public interface TestService {
    public List<TestDto> getUserList();
    public TestDto getUser(Integer idx);
    public void  postUser(TestDto testDto);
    public void deleteUser(Integer idx);
    public TestDto updateUser(TestDto testDto);
}

