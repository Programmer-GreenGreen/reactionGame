package com.example.reactionGame.service;

import com.example.reactionGame.dto.MemberDto;

import java.util.List;

public interface MemberService {
    public List<MemberDto> getUserList();
    public MemberDto getUser(Integer idx);
    public void  postUser(MemberDto memberDto);
    public void deleteUser(Integer idx);
    public MemberDto updateUser(MemberDto memberDto);
}

