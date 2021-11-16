package com.example.reactionGame.mapper;

import com.example.reactionGame.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    List<MemberDto> getMemberList();

    Optional<MemberDto> getMember(Integer id);

    Integer postMember(MemberDto memberDto);

    Optional<MemberDto> updateMember(MemberDto memberDto);

    void  deleteMember(Integer id);


}
