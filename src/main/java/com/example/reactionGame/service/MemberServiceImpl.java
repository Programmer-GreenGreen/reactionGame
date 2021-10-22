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
    public List<MemberDto> getMemberList() {
        return memberMapper.getMemberList();
    }

    @Override
    public MemberDto getMember(Integer idx) {
        log.error("memberError");
        MemberDto memberDto = memberMapper.getMember(idx).orElseThrow(()-> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND));
        return memberDto;
    }

    @Override
    public void postMember(MemberDto memberDto) {
        memberMapper.postMember(memberDto);
    }

    @Override
    public void deleteMember(Integer idx) {
        memberMapper.deleteMember(idx);
    }

    @Override
    public MemberDto updateMember(MemberDto memberDto) {
        MemberDto memberDto1 =  memberMapper.getMember(memberDto.getIdx()).orElseThrow(()-> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND));

        return memberMapper.updateMember(memberDto1).orElseThrow(()-> new EntityNotFoundException(ErrorCode.ENTITY_NOT_FOUND));

    }
}
