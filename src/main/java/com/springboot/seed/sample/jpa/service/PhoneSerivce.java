package com.springboot.seed.sample.jpa.service;

import com.springboot.seed.sample.jpa.domain.Member;
import com.springboot.seed.sample.jpa.domain.Phone;
import com.springboot.seed.sample.jpa.dto.PhoneDto;
import com.springboot.seed.sample.jpa.repository.PhoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PhoneSerivce {
    private static final Logger log = LoggerFactory.getLogger(PhoneSerivce.class);

    @Autowired
    MemberService memberService;

    @Autowired
    PhoneRepository phoneRepository;

    public Phone save(PhoneDto phoneDto) {
        Member member = memberService.getOne(phoneDto.getMemberId());

        if (member != null) {
            return phoneRepository.save(Phone.builder()
                .member(member)
                .number(phoneDto.getNumber())
                .build());
        } else {
            throw new RuntimeException("can't find member " + phoneDto.getMemberId());
        }
    }

    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }
}
