package com.example.reactionGame.mapper;

import com.example.reactionGame.dto.TestDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper {

    List<TestDto> getUserList();

    TestDto getUser(Integer id);

    void postUser(TestDto testDto);

    TestDto updateUser(TestDto testDto);

    void  deleteUser(Integer id);


}
