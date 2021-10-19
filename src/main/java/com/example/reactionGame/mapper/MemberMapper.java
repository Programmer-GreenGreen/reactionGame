package com.example.reactionGame.mapper;

import com.example.reactionGame.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    List<MemberDto> getUserList();

    Optional<MemberDto> getUser(Integer id);

    void postUser(MemberDto memberDto);

    Optional<MemberDto> updateUser(MemberDto memberDto);

    void  deleteUser(Integer id);


}
