package com.example.reactionGame.service;

import com.example.reactionGame.dto.MemberDto;

import java.util.List;

/***
 * MemberService
 * @version 1.0
 * @author Lee
 */
public interface MemberService {
    public List<MemberDto> getMemberList();
    public MemberDto getMember(Integer idx);
    public Integer postMember(MemberDto memberDto);
    public void deleteMember(Integer idx);
    public MemberDto updateMember(MemberDto memberDto);
}

