package com.example.reactionGame.service;

import com.example.reactionGame.dto.MemberDto;
import com.example.reactionGame.exception.EntityNotFoundException;
import com.example.reactionGame.exception.ErrorCode;
import com.example.reactionGame.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    public List<MemberDto> getUserList() {
        return memberMapper.getUserList();
    }

    @Override
    public MemberDto getUser(Integer idx) {
        log.error("memberError");
        MemberDto memberDto = memberMapper.getUser(idx).orElseThrow(()-> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND));
        return memberDto;
    }

    @Override
    public void postUser(MemberDto memberDto) {
        memberMapper.postUser(memberDto);
    }

    @Override
    public void deleteUser(Integer idx) {
        memberMapper.deleteUser(idx);
    }

    @Override
    public MemberDto updateUser(MemberDto memberDto) {
        /*MemberDto memberDto1 =  memberMapper.getUser(memberDto.getIdx());

        return memberMapper.updateUser(memberDto1);*/
        return null;
    }
}
