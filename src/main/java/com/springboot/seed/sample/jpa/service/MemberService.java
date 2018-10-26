package com.springboot.seed.sample.jpa.service;

import com.springboot.seed.sample.jpa.domain.Member;
import com.springboot.seed.sample.jpa.dto.MemberDto;
import com.springboot.seed.sample.jpa.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MemberService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    MemberRepository memberRepository;

    public Member save(MemberDto memberDto) {
        return memberRepository.save(Member.builder()
            .memberName(memberDto.getMemberName())
            .teamId(memberDto.getTeamId())
            .build());
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member getOne(Long id) {
        return memberRepository.findById(id).orElse(null);
    }
}
