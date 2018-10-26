package com.springboot.seed.sample.jpa;

import com.springboot.seed.sample.jpa.domain.Member;
import com.springboot.seed.sample.jpa.domain.Phone;
import com.springboot.seed.sample.jpa.domain.Post;
import com.springboot.seed.sample.jpa.domain.Team;
import com.springboot.seed.sample.jpa.dto.MemberDto;
import com.springboot.seed.sample.jpa.dto.PhoneDto;
import com.springboot.seed.sample.jpa.dto.PostDto;
import com.springboot.seed.sample.jpa.dto.TeamDto;
import com.springboot.seed.sample.jpa.service.MemberService;
import com.springboot.seed.sample.jpa.service.PhoneSerivce;
import com.springboot.seed.sample.jpa.service.PostService;
import com.springboot.seed.sample.jpa.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sample")
public class SampleJpaController {

    private static final Logger log = LoggerFactory.getLogger(SampleJpaController.class);

    @Autowired
    private PostService postService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private PhoneSerivce phoneSerivce;

    @PostMapping("/jpa/post")
    public Post savePost(@RequestBody PostDto postDto) {
        return postService.save(postDto);
    }

    @GetMapping("/jpa/posts")
    public List<Post> findAllPost() {
        return postService.findAll();
    }

    @PostMapping("/jpa/team")
    public Team saveTeam(@RequestBody TeamDto teamDto) {
        return teamService.save(teamDto);
    }

    @GetMapping("/jpa/teams")
    public List<Team> findAllTeam() {
        return teamService.findAll();
    }

    @PostMapping("/jpa/member")
    public Member saveMember(@RequestBody MemberDto memberDto) {
        return memberService.save(memberDto);
    }

    @GetMapping("/jpa/members")
    public List<Member> findAllMember() {
        return memberService.findAll();
    }

    @PostMapping("/jpa/phone")
    public Phone savePhone(@RequestBody PhoneDto phoneDto) {
        return phoneSerivce.save(phoneDto);
    }

    @GetMapping("/jpa/phones")
    public List<Phone> findAllPhone() {
        return phoneSerivce.findAll();
    }
}
